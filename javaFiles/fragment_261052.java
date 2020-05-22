public class PDFVisibleTextStripper extends PDFTextStripper {
    public PDFVisibleTextStripper() throws IOException {
        addOperator(new AppendRectangleToPath());
        addOperator(new ClipEvenOddRule());
        addOperator(new ClipNonZeroRule());
        addOperator(new ClosePath());
        addOperator(new CurveTo());
        addOperator(new CurveToReplicateFinalPoint());
        addOperator(new CurveToReplicateInitialPoint());
        addOperator(new EndPath());
        addOperator(new FillEvenOddAndStrokePath());
        addOperator(new FillEvenOddRule());
        addOperator(new FillNonZeroAndStrokePath());
        addOperator(new FillNonZeroRule());
        addOperator(new LineTo());
        addOperator(new MoveTo());
        addOperator(new StrokePath());
    }

    @Override
    protected void processTextPosition(TextPosition text) {
        Matrix textMatrix = text.getTextMatrix();
        Vector start = textMatrix.transform(new Vector(0, 0));
        Vector end = new Vector(start.getX() + text.getWidth(), start.getY());

        PDGraphicsState gs = getGraphicsState();
        Area area = gs.getCurrentClippingPath();
        if (area == null || (area.contains(start.getX(), start.getY()) && area.contains(end.getX(), end.getY())))
            super.processTextPosition(text);
    }

    private GeneralPath linePath = new GeneralPath();

    void deleteCharsInPath() {
        for (List<TextPosition> list : charactersByArticle) {
            List<TextPosition> toRemove = new ArrayList<>();
            for (TextPosition text : list) {
                Matrix textMatrix = text.getTextMatrix();
                Vector start = textMatrix.transform(new Vector(0, 0));
                Vector end = new Vector(start.getX() + text.getWidth(), start.getY());
                if (linePath.contains(start.getX(), start.getY()) || linePath.contains(end.getX(), end.getY())) {
                    toRemove.add(text);
                }
            }
            if (toRemove.size() != 0) {
                System.out.println(toRemove.size());
                list.removeAll(toRemove);
            }
        }
    }

    public final class AppendRectangleToPath extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            if (operands.size() < 4) {
                throw new MissingOperandException(operator, operands);
            }
            if (!checkArrayTypesClass(operands, COSNumber.class)) {
                return;
            }
            COSNumber x = (COSNumber) operands.get(0);
            COSNumber y = (COSNumber) operands.get(1);
            COSNumber w = (COSNumber) operands.get(2);
            COSNumber h = (COSNumber) operands.get(3);

            float x1 = x.floatValue();
            float y1 = y.floatValue();

            // create a pair of coordinates for the transformation
            float x2 = w.floatValue() + x1;
            float y2 = h.floatValue() + y1;

            Point2D p0 = context.transformedPoint(x1, y1);
            Point2D p1 = context.transformedPoint(x2, y1);
            Point2D p2 = context.transformedPoint(x2, y2);
            Point2D p3 = context.transformedPoint(x1, y2);

            // to ensure that the path is created in the right direction, we have to create
            // it by combining single lines instead of creating a simple rectangle
            linePath.moveTo((float) p0.getX(), (float) p0.getY());
            linePath.lineTo((float) p1.getX(), (float) p1.getY());
            linePath.lineTo((float) p2.getX(), (float) p2.getY());
            linePath.lineTo((float) p3.getX(), (float) p3.getY());

            // close the subpath instead of adding the last line so that a possible set line
            // cap style isn't taken into account at the "beginning" of the rectangle
            linePath.closePath();
        }

        @Override
        public String getName() {
            return "re";
        }
    }

    public final class StrokePath extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.reset();
        }

        @Override
        public String getName() {
            return "S";
        }
    }

    public final class FillEvenOddRule extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.setWindingRule(GeneralPath.WIND_EVEN_ODD);
            deleteCharsInPath();
            linePath.reset();
        }

        @Override
        public String getName() {
            return "f*";
        }
    }

    public class FillNonZeroRule extends OperatorProcessor {
        @Override
        public final void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.setWindingRule(GeneralPath.WIND_NON_ZERO);
            deleteCharsInPath();
            linePath.reset();
        }

        @Override
        public String getName() {
            return "f";
        }
    }

    public final class FillEvenOddAndStrokePath extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.setWindingRule(GeneralPath.WIND_EVEN_ODD);
            deleteCharsInPath();
            linePath.reset();
        }

        @Override
        public String getName() {
            return "B*";
        }
    }

    public class FillNonZeroAndStrokePath extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.setWindingRule(GeneralPath.WIND_NON_ZERO);
            deleteCharsInPath();
            linePath.reset();
        }

        @Override
        public String getName() {
            return "B";
        }
    }

    public final class ClipEvenOddRule extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.setWindingRule(GeneralPath.WIND_EVEN_ODD);
            getGraphicsState().intersectClippingPath(linePath);
        }

        @Override
        public String getName() {
            return "W*";
        }
    }

    public class ClipNonZeroRule extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.setWindingRule(GeneralPath.WIND_NON_ZERO);
            getGraphicsState().intersectClippingPath(linePath);
        }

        @Override
        public String getName() {
            return "W";
        }
    }

    public final class MoveTo extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            if (operands.size() < 2) {
                throw new MissingOperandException(operator, operands);
            }
            COSBase base0 = operands.get(0);
            if (!(base0 instanceof COSNumber)) {
                return;
            }
            COSBase base1 = operands.get(1);
            if (!(base1 instanceof COSNumber)) {
                return;
            }
            COSNumber x = (COSNumber) base0;
            COSNumber y = (COSNumber) base1;
            Point2D.Float pos = context.transformedPoint(x.floatValue(), y.floatValue());
            linePath.moveTo(pos.x, pos.y);
        }

        @Override
        public String getName() {
            return "m";
        }
    }

    public class LineTo extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            if (operands.size() < 2) {
                throw new MissingOperandException(operator, operands);
            }
            COSBase base0 = operands.get(0);
            if (!(base0 instanceof COSNumber)) {
                return;
            }
            COSBase base1 = operands.get(1);
            if (!(base1 instanceof COSNumber)) {
                return;
            }
            // append straight line segment from the current point to the point
            COSNumber x = (COSNumber) base0;
            COSNumber y = (COSNumber) base1;

            Point2D.Float pos = context.transformedPoint(x.floatValue(), y.floatValue());

            linePath.lineTo(pos.x, pos.y);
        }

        @Override
        public String getName() {
            return "l";
        }
    }

    public class CurveTo extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            if (operands.size() < 6) {
                throw new MissingOperandException(operator, operands);
            }
            if (!checkArrayTypesClass(operands, COSNumber.class)) {
                return;
            }
            COSNumber x1 = (COSNumber) operands.get(0);
            COSNumber y1 = (COSNumber) operands.get(1);
            COSNumber x2 = (COSNumber) operands.get(2);
            COSNumber y2 = (COSNumber) operands.get(3);
            COSNumber x3 = (COSNumber) operands.get(4);
            COSNumber y3 = (COSNumber) operands.get(5);

            Point2D.Float point1 = context.transformedPoint(x1.floatValue(), y1.floatValue());
            Point2D.Float point2 = context.transformedPoint(x2.floatValue(), y2.floatValue());
            Point2D.Float point3 = context.transformedPoint(x3.floatValue(), y3.floatValue());

            linePath.curveTo(point1.x, point1.y, point2.x, point2.y, point3.x, point3.y);
        }

        @Override
        public String getName() {
            return "c";
        }
    }

    public final class CurveToReplicateFinalPoint extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            if (operands.size() < 4) {
                throw new MissingOperandException(operator, operands);
            }
            if (!checkArrayTypesClass(operands, COSNumber.class)) {
                return;
            }
            COSNumber x1 = (COSNumber) operands.get(0);
            COSNumber y1 = (COSNumber) operands.get(1);
            COSNumber x3 = (COSNumber) operands.get(2);
            COSNumber y3 = (COSNumber) operands.get(3);

            Point2D.Float point1 = context.transformedPoint(x1.floatValue(), y1.floatValue());
            Point2D.Float point3 = context.transformedPoint(x3.floatValue(), y3.floatValue());

            linePath.curveTo(point1.x, point1.y, point3.x, point3.y, point3.x, point3.y);
        }

        @Override
        public String getName() {
            return "y";
        }
    }

    public class CurveToReplicateInitialPoint extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            if (operands.size() < 4) {
                throw new MissingOperandException(operator, operands);
            }
            if (!checkArrayTypesClass(operands, COSNumber.class)) {
                return;
            }
            COSNumber x2 = (COSNumber) operands.get(0);
            COSNumber y2 = (COSNumber) operands.get(1);
            COSNumber x3 = (COSNumber) operands.get(2);
            COSNumber y3 = (COSNumber) operands.get(3);

            Point2D currentPoint = linePath.getCurrentPoint();

            Point2D.Float point2 = context.transformedPoint(x2.floatValue(), y2.floatValue());
            Point2D.Float point3 = context.transformedPoint(x3.floatValue(), y3.floatValue());

            linePath.curveTo((float) currentPoint.getX(), (float) currentPoint.getY(), point2.x, point2.y, point3.x, point3.y);
        }

        @Override
        public String getName() {
            return "v";
        }
    }

    public final class ClosePath extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.closePath();
        }

        @Override
        public String getName() {
            return "h";
        }
    }

    public final class EndPath extends OperatorProcessor {
        @Override
        public void process(Operator operator, List<COSBase> operands) throws IOException {
            linePath.reset();
        }

        @Override
        public String getName() {
            return "n";
        }
    }
}