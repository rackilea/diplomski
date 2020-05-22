InputStream in = p.getErrorStream();
int c;
while ((c = in.read()) != -1)
{
    System.out.print((char)c);
}
in.close();