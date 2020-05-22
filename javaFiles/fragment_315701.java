@Override
           public void actionPerformed(ActionEvent e) {
              if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
                 System.out.println("control pressed");
              } else {
                 System.out.println("ActionListener invoked");
              }
           }
        });