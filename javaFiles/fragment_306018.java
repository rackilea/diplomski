String nomImage = "img";
int id = 1511;
try {
    URL site = new URL("http://ts2.travian.fr/hero_body.php?uid="+id ); 
    File file = new File(nomImage+id+".png");
    file.createNewFile();
    InputStream in = site.openStream();
    OutputStream out = new FileOutputStream(file);
    byte[] b = new byte[2048];
    int length;
    while ((length = in.read(b)) != -1) {
        out.write(b, 0, length);
    }
    in.close(); 
    out.close();
} catch (MalformedURLException ex) {
    ex.printStackTrace();
} catch (FileNotFoundException ex) {
    ex.printStackTrace();       
} catch (IOException ex) {
    ex.printStackTrace();       
}