JTextField sampleTxtFld= new JTextField();

   sampleTxtFld.addKeyListener(new KeyAdapter() {


          public void keyPressed(KeyEvent e) 
         {
              if((e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X)
              {
                    //identifies whether Ctrl + X has been pressed
                    // do some action here
              }
         }

        public void keyReleased(KeyEvent e) 
        {
              //some key released code here
        }
         public void keyTyped(KeyEvent e) {
         }


   });