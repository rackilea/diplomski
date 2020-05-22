final URL url = new URL("http://upload.wikimedia.org/wikipedia/commons/9/94/Giewont_and_Wielka_Turnia.jpg");  //1
final InputStream input = url.openStream();  //2
final OutputStream output = new BufferedOutputStream(new FileOutputStream("giewont.jpg")); //3
IOUtils.copy(input, output);  //4
input.close();  //5
output.close();