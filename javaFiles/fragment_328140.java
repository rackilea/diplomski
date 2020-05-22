public static void main(String[] args) throws Exception {
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

        File file = new File("cookie.file");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Set<Cookie> cookies = (Set<Cookie>) in.readObject();
        in.close();

        WebClient wc = new WebClient();

        Iterator<Cookie> i = cookies.iterator();
        while (i.hasNext()) {
            wc.getCookieManager().addCookie(i.next());
        }

        HtmlPage p = wc.getPage("http://google.com");

        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("cookie.file"));
        out.writeObject(wc.getCookieManager().getCookies());
        out.close();
    }