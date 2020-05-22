InputStream is = null;

try {
    is = new FileInputStream(new File("lolwtf"));
    //read stuff here
} catch (IOException e) {
    System.out.println("omfg, it didn't work");
} finally {
    is.close();
}