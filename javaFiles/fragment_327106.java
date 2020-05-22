for (int i = 0; i < jb.length; i++){
          jb[i] = new JButton("");
          final int index = i;
          jb[i].addActionListener(new ActionListener(){
               @Override
              public void actionPerformed(ActionEvent e){
                  jb[index].setText("O");
              }
          });
          p1.add(jb[i]);

      }