public class MainFrame {
    // [...]

    private void openModelActionPerformed(java.awt.event.ActionEvent evt) {
        // [...]
        filename = f.getAbsolutePath();
        PrincipalFrame prFrame1 = new PrincipalFrame();
        prFrame1.setSpecification(readSpecification());
        prFrame1.setVisible(true);
    }

    // [...]
}