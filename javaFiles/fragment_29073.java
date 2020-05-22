FileOutputStream output=new FileOutputStream("C:\\Users\\Aitor\\Desktop\\program.exe");
int b = 0;
byte[] buff = new byte[1024];
while ((b=program.read(buff))>=0)
{
    output.write(buff, 0, b);
}
output.close();