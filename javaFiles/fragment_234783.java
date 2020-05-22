@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            for(Polygon poly : polygons) {
                g.drawPolygon(poly);
            }
        }