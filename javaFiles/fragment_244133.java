class ILaunchedThatWinModal extends vLayout{

     //blablabla code here...

     public void launchWinModal(){
          final Window winModal = new Window();
          //configuring the winModal.
          winModal.addCloseClickHandler(new CloseClickHandler() {
                public void onCloseClick(CloseClickEvent event) {
                   ILaunchedThatWindModal.this.markForRedraw(); //<-Look here
                   winModal.destroy();
                }
           });
     }
}