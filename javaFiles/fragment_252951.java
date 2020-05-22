JFileChooser chooser = new JFileChooser();
int returnValue = chooser.showOpenDialog(null);
if(returnValue == JFileChooser.APPROVE_OPTION){
    //make stuff if approved
} else if(returnValue == JFileChooser.CANCEL_OPTION){
    //make stuff if canceled
}