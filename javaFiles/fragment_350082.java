public class Dialog_Input extends javax.swing.JPanel {

private JFrame/*or other Object of parent Class*/ parentFrame; 

public Dialog_Input(JFrame parent) {
    parentFrame = parent;
    initComponents(); //lets assume this has two buttons and a couple of controls..
    //setup onCloseListener
}
public void setDialogData(String id, String name, String desc){
    lblDialog_ID.setText(id);
    lblDialog_Name.setText(name);
    lblDialog_Desc.setText(desc);
}

//method being called on close
private void onClose(){
    parentFrame.setA(settingA);
    parentFrame.setB(settingB);
    parentFrame.setC(settingC);
}