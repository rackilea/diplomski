JInternalFrame internalFrame1;

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      try
      {

       if(internalFrame1 !=null) {//make sure its not null
           internalFrame1.dispose();//close the previos internalframe
       }

        tst t = new tst();
        internalFrame1 = new JInternalFrame("Test Window1"); //create new instance of internal frame
        internalFrame1.add(t.getContentPane());
        internalFrame1.pack();

        internalFrame1.setVisible(true);
        q.add(internalFrame1);

        internalFrame1.setClosable(true);  

        BasicInternalFrameUI ui = (BasicInternalFrameUI)internalFrame1.getUI();
        Container north = (Container)ui.getNorthPane();
        north.remove(0);
        north.validate();
        north.repaint();

        for(MouseListener listener : ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().getMouseListeners()){
        ((javax.swing.plaf.basic.BasicInternalFrameUI) internalFrame1.getUI()).getNorthPane().removeMouseListener(listener);
        }

         internalFrame1.setSelected(true);

      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, ex);
      }
    }