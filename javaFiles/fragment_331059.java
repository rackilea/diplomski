private void ButtonActionPerformed(java.awt.event.ActionEvent evt) {                                       
    Name = Text.getText();
    FrameShow show = new FrameShow(Name);
    this.dispose();
    show.setVisible(true);
} 

public FrameShow(String name) {
    initComponents();
    Label.setText(name);
}