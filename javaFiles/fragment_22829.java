Path invertedCircle = new Path();
            int radius = (canvas.getWidth() < canvas.getHeight()) ? canvas
                    .getWidth() / 4 : canvas.getHeight() / 2;
            invertedCircle.addCircle(canvas.getWidth() / 2,
                    canvas.getHeight() / 2, radius, Direction.CW);
            invertedCircle.setFillType(FillType.INVERSE_EVEN_ODD);
            Paint p = new Paint();
            p.setColor(Color.BLACK);
            canvas.drawPath(invertedCircle, p);