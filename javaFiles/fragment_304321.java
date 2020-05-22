File xls = new File("exported.xls"); // or whatever your file is
FileInputStream in = new FileInputStream(xls);
OutputStream out = response.getOutputStream();

byte[] buffer= new byte[8192]; // use bigger if you want
int length = 0;

while ((length = in.read(buffer)) > 0){
     out.write(buffer, 0, length);
}
in.close();
out.close();