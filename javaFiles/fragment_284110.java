public void jsAppletCall() {
      //       do you java stuff here 
      // then 
      // call the javascript from the applet using the JSOBject 
              JSObject win = JSObject.getWindow(this);
              win.eval("callJSFromMyAppletMessage();");
     }