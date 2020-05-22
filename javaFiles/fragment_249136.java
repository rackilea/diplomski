File f = new File("C:\\Users\\User_Name\\Desktop\\test.html");
    try {
        webView.getEngine().load(f.toURI().toURL().toString());
    } catch (MalformedURLException ex) {
        Logger.getLogger(TestWeb.class.getName()).log(Level.SEVERE, null, ex);
    }