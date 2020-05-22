public class Read extends javax.swing.JInternalFrame {
    private View view;  // *******

    // give the constructor a View parameter
    public Read(View view) {

        this.view = view; // ***** update the view field

        initComponents();
        pack();
        DefaultListModel model = new DefaultListModel();
        jList1.setModel(model);
        File folder = new File("/home/Naruto/Dattebayo");
        File[] listOfFiles = folder.listFiles();
        for(File file : listOfFiles){
            model.addElement(file.getName());

        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        String selected = (String) jList1.getSelectedValue();

        // this should work now
        view.setText(selected); 
        view.setVisible(true);  
        this.setVisible(false);       
    }                                        
}