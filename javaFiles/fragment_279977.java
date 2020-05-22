InputStream in = response.getEntityInputStream();
if (in != null) {
    File f = new File("C://Data/test/downloaded/testnew.pdf");

    //@TODO copy the in stream to the file f

    System.out.println("Result size:" + f.length() + " written to " + f.getPath());
}