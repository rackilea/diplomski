public static void addText(final String str){
  txtArea.getDisplay().asyncExec (new Runnable () {
    public void run () {
       if (!txtArea.isDisposed())
          txtArea.append(str);
    }
  }); 
}