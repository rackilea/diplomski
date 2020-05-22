KeyAdapter adapter = new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
              char c = e.getKeyChar();
              if (!((c >= '0') && (c <= '9') ||
                 (c == KeyEvent.VK_BACK_SPACE) ||
                 (c == KeyEvent.VK_DELETE))) {
                getToolkit().beep();
                e.consume();
              }
            }
          };

someTextField.addKeyListener(adapter);
someOtherTextField.addKeyListener(adapter);