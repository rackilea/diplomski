WaitingDialog waitingDialog = new WaitingDialog("Is this a dialog?", "Yes", "No");

handler.post(waitingDialog);
//Wait here for onclick to be called before you proceed
while(!waitingDialog.isFinished())

if (waitingDialog.getDialog()) {
    //clicked yes
} else {
    //clicked no
}