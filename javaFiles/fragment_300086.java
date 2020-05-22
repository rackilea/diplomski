private static native boolean getNewWindowStatus(BodyElement childWin) /*-{
    var ret = false;

    if (childWin.closed) {
       ret = true;
    } 

    return ret;
}-*/;