iStream = new BufferedInputStream(connect.getInputStream());

FileOutputStream fos1 = new FileOutputStream(new File("C:/Users/huehuehue/Documents/Uni/D0036D/test1.JPG"));
FileOutputStream fos2 = new FileOutputStream(new File("C:/Users/huehuehue/Documents/Uni/D0036D/test2.JPG"));
int c=0;
while ((c = iStream.read()) != -1) {
    fos1.write(c);
    fos2.write(c);
}
fos1.close();
fos2.close();
iStream.close();