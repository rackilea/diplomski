//Add instance variable for parent
private JFrame parent;

//Add JFrame to the constructor
public SV2(SomeType someParameter, OtherType foo, JFrame parent) {
    this.parent = parent;
    //rest of constructor code...
}

//Use JFrame to resize
private void btn_closeActionPerformed(ActionEvent evt) {
    parent.setSize(988, 430);
    //rest of code triggered by close button...
}