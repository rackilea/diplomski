boolean doesAcceptRanges(String str)
{
    URLConnection cn1 = new URL(str).openConnection();
    cn1.setRequestProperty("Range", "bytes=" + 0 + "-" + 8192);
    cn1.connect();
    InputStream input1 = cn1.getInputStream();
    URLConnection cn2 = new URL(str).openConnection();
    cn2.setRequestProperty("Range", "bytes=" + 8193+ "-" + 16385);
    cn2.connect();
    InputStream input2 = cn2.getInputStream();
    byte[] buffer1 = new byte[8192];
    byte[] buffer2 = new byte[8192];
    input1.read(buffer1);
    input2.read(buffer2);
    if(Arrays.equals(buffer1, buffer2))
        return false;
    else
        return true;
}