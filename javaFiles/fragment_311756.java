public static native void trackEvent(String category, String action, String label) /*-{
    $wnd._gaq.push(['_trackEvent', category, action, label]);
}-*/;

public static native void trackEvent(String category, String action, String label, int intArg) /*-{
    $wnd._gaq.push(['_trackEvent', category, action, label, intArg]);
}-*/;

public static native void trackPageview(String url) /*-{
    $wnd._gaq.push(['_trackPageview', url]);
}-*/;