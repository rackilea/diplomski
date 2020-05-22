GetMethod get = new GetMethod(href);
InputStream in = get.getResponseBodyAsStream();
File file=new File("csv-file-"+ (++filesCounter) + ".csv");
OutputStream out = new FileOutputStream(file);
int read = 0;
byte[] bytes = new byte[1024];
while ((read = inputStream.read(bytes)) != -1) {
    out.write(bytes, 0,  read);
}
in.close();
out.flush();
out.close();