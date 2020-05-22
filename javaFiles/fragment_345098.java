final ContentAdapter ca = moz.getChromeAdapter().getContentAdapter();

nsIURIContentListener mycl = new nsIURIContentListener() {
    public boolean onStartURIOpen(nsIURI aURI) {
        System.out.println(aURI.getHost() + aURI.getPath());
        return true;
    }
    public boolean doContent(String aContentType, boolean aIsContentPreferred, nsIRequest aRequest, nsIStreamListener[] aContentHandler) { 
        System.out.println("1");
        return ca.doContent(aContentType, aIsContentPreferred, aRequest, aContentHandler); 
    }
    public boolean isPreferred(String aContentType, String[] aDesiredContentType) { 
        System.out.println("2");
        return ca.isPreferred(aContentType, aDesiredContentType); 
    }
    public boolean canHandleContent(String aContentType, boolean aIsContentPreferred, String[] aDesiredContentType) { 
        System.out.println("3");
        return ca.canHandleContent(aContentType, aIsContentPreferred, aDesiredContentType); 
    }
    public nsISupports getLoadCookie() { 
        System.out.println("4");
        return ca.getLoadCookie(); 
    }
    public void setLoadCookie(nsISupports aLoadCookie) { 
        System.out.println("5");
        ca.setLoadCookie(aLoadCookie); 
    }
    public nsIURIContentListener getParentContentListener() { 
        System.out.println("6");
        return ca.getParentContentListener(); 
    }
    public void setParentContentListener(nsIURIContentListener aParentContentListener) { 
        System.out.println("7");
        ca.setParentContentListener(aParentContentListener); 
    }
    public nsISupports queryInterface(String uuid) { 
        System.out.println("8");
        return ca.queryInterface(uuid); 
    }
 };

 moz.getChromeAdapter().getWebBrowser().setParentURIContentListener(mycl);