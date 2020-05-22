public static final native void setAppHeading(String heading) /*-{
    if(typeof $wnd.Android !== 'undefined'){ 
        $wnd.Android.setHeading(heading);
        return;
    }
}-*/;