final Robot r=new Robot();
f.addMouseMotionListener(new MouseMotionListener(){
        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {

              r.mouseMove(20, e.getY());
        }
    });