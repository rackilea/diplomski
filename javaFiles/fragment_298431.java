try {
    URL u = new URL("http://java.sun.com/index.html");
    URLConnection conn = u.openConnection();
    InputStream stream = conn.getInputStream();
    Scanner in = new Scanner(stream); 
} catch (RuntimeException e) {
    //Handle caught exception
    System.err.println(e.getMessage());
}