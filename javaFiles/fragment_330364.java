int n;
byte[] buffer=new byte[4096];
do
{
    n=input.read(buffer);
    if (n>0)
    {
        output.write(buffer, 0, n);
    }
}
while (n>=0);