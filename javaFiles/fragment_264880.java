public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // First get the private WebViewCore field...
        Field fWvc = WebView.class.getDeclaredField("webViewCore");
        fWvc.setAccessible(true);
        System.out.println(fWvc);

        // Then get an instance of a WebView; you already have one,
        // I'm constructing one...
        WebView wv = new WebView();
        WebViewCore wvc = (WebViewCore) fWvc.get(wv);
        System.out.println(wvc);

        // Now get the private String field from the WebViewCore class...
        Field fS = WebViewCore.class.getDeclaredField("s");
        fS.setAccessible(true);
        System.out.println(fS);

        // Now get the value of the private String field from the instance
        // of the WebViewCore we retrieved above...
        String s = (String) fS.get(wvc);
        System.out.println(s);
    }

}