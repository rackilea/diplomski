JXMapViewer viewer;
//initialize somehow.
viewer.addMouseListener(new MouseAdapter(){
     public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3){
                java.awt.Point p = e.getPoint();
                GeoPosition geo = viewer.convertPointToGeoPosition(p);
                System.out.println("X:"+geo.getLattitude()+",Y:"+geo.getLongitude());
            }
     }
});