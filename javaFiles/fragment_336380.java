public class PanelTrial extends javax.swing.JPanel implements AncestorListener {

     private Container frame;
     private javax.swing.JPanel btnPanel;

     public PanelTrial(Container frame) {
           this.frame = frame;
           initComponents();
           createBtnPanel();
           btnPanel.addAncestorListener(this);
     }

      // Called on btn click event - to show/hide btnPanel
      private void updateRightPanel(boolean showBtnPanel) {
           jPanel1.removeAll();

           GroupLayout layout = (GroupLayout) jPanel1.getLayout();

           if (showBtnPanel) {
               layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(btnPanel));
               layout.setVerticalGroup(layout.createParallelGroup(
                Alignment.TRAILING).addComponent(btnPanel));

                } else {
                layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(rightPanel));
                layout.setVerticalGroup(layout.createParallelGroup(
                Alignment.TRAILING).addComponent(rightPanel));

            }

            jPanel1.validate();
            this.validate();
       }


     @Override
     public void ancestorAdded(AncestorEvent e) {
           if (e.getSource() == btnPanel) 
                System.out.println("BTNSPANEL LOADED / ADDED");
     }

     @Override
     public void ancestorMoved(AncestorEvent e) {
                 // This is of no use for your purpose 
           System.out.println("Anc Moved - " + e.getSource());
      }

      @Override
      public void ancestorRemoved(AncestorEvent e) {
           if (e.getSource() == btnPanel) 
             System.out.println("BTNSPANEL UNLOADED / REMOVED");
      }