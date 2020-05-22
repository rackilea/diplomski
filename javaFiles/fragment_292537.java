ckbxTestCheckBox.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
                for(int i = 0; i < rdbtnTest.length; i++){

                    rdbtnTest[i].setEnabled(!ckbxTestCheckBox.isSelected());

                    if(!ckbxTestCheckBox.isSelected()) 
                       rdbtnTest[i].setSelected(false);
                }

          }
        });