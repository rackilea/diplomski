new DefaultMapController(this) {
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getPoint());
            Point  p = e.getPoint();
            lat = map.getPosition(p).getLat();
            lon = map.getPosition(p).getLon();
        }};