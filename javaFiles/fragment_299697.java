XYLineAndShapeRenderer renderer =  new XYLineAndShapeRenderer(true, true){
        Shape ellipse = new Ellipse2D.Double(-3.0,-3.0,8.0,8.0);
        Shape upTriangle = ShapeUtilities.createUpTriangle(4.0f);
        Shape diamond = ShapeUtilities.createDiamond(4.0f);
        Shape downTriangle = ShapeUtilities.createDownTriangle(4.0f);


        @Override
        public Shape getItemShape(int row, int column) {
            Double value = (Double) plot.getDataset(0).getY(row, column);
            if (value > 6.0 ) {
                return ellipse;
            } else if (value >= 5.0 ) {
                return upTriangle;
            } else if (value >= 2.0 ) {
                return diamond;
            }else {
                return downTriangle;
            }
        }

    };

  plot.setRenderer(renderer);