t.addKeyListener(new KeyListener(){

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            JTextField bt = (JTextField)e.getSource();
            if(bt.getText().trim().length()>0){
                t1.setEnabled(true);
            }
            else
                t1.setEnabled(false);
        }
    });