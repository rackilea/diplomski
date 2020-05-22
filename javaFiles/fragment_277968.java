@Override
        public void keyPressed(KeyEvent arg0) {

            if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
                PaintThread th = new PaintThread(p);
                th.start();
            }
        }