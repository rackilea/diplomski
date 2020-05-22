private void setMapImage()
{
    Queries queries = new Queries(dbConnection, connection);
    List<ArrayList<Integer>> allGeo = queries.getBuilding();
    List<Polygon> polyList = new ArrayList<Polygon>();
    for(int i = 0; i < allGeo.size(); i++)
    {
        int[] xPoly = queries.separateCoordinates(allGeo.get(i),0);
        int[] yPoly = queries.separateCoordinates(allGeo.get(i),1);
        poly = new Polygon(xPoly, yPoly, xPoly.length);
        polyList.add(poly);
    }   
    background=new JLabel(new ImageIcon("image.JPG"),SwingConstants.LEFT)
    {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.YELLOW);
            for(final Polygon poly : polyList){
                g.drawPolygon(poly);
            }
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(820, 580);
        }
    };

    background.setVerticalAlignment(SwingConstants.TOP);
    frame.add(background);
    background.setLayout(new FlowLayout());
    frame.setVisible(true);
}