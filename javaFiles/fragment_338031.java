// image for row 'x' download complete.  save image as member data
 //  that can be accessed in drawListRow().

 UiApplication.getUiApplication().invokeLater(new Runnable() {
    public void run() {
       _list.invalidate(x);
    }
 });