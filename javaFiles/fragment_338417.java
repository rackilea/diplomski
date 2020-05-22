byte[] buff = new byte[1024];
while((read = bIs.read(buff)) != -1)
{
    byte[] enc = encrypt(buff);
    bOs.write(enc, 0, enc.length);
}