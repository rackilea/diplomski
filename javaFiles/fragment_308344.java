viewer.getTextWidget().addKeyListener(new KeyListener() {
 @Override
  public void keyReleased(KeyEvent e) {
       // TODO Auto-generated method stub
  }

 @Override
 public void keyPressed(KeyEvent e) {
   if( isUndoKeyPress( e )){
     viewer.doOperation(ITextOperationTarget.UNDO);
   }  else if( isRedoKeyPress( e )) {
      viewer.doOperation(ITextOperationTarget.REDO);
   }
 }

  private boolean isRedoKeyPress(KeyEvent e) {
     return (( e.stateMask & SWT.CONTROL ) > 0) && ((e.keyCode =='y' ) (e.keyCode == 'Y'));
   }

   private boolean isUndoKeyPress(KeyEvent e) {
          return (( e.stateMask & SWT.CONTROL) > 0 ) && ((e.keyCode == 'z' ) (e.keyCode =='Z'));
   }
});