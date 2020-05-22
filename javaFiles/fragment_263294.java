public class MyGui {
    // instance field to hold reference to currently displayed JInternalFrame
    private JInternalFrame currentInternalFrame = null;

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {        
        if (currentInternalFrame != null) {
            currentInternalFrame.dispose(); // clear current one
        }

        String st = TextField.getText().toString(); // in TextField i enter the JInternal Frame Name
        String clazzname = "practice."+st;         // practice is the package name  
        try {

            // JInternalFrame obj1 = (JInternalFrame) Class.forName( clazzname ).newInstance();

            currentInternalFrame = (JInternalFrame) Class.forName( clazzname ).newInstance();

            currentInternalFrame.setVisible(true);
            jPanel1.add(currentInternalFrame);           
        } catch(Exception e) {
            System.out.println("error "+e);
        }
    } 
}