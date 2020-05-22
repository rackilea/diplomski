CustomDialog dialog;
// initialization stuff, blah blah
dialog.setDialogResult(new OnMyDialogResult(){
    public void finish(String result){
        // now you can use the 'result' on your activity
    }
});