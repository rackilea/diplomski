@Test
public void testFileRWAsArray() throws IOException{
    String f1String="";
    byte[] bytes=FileUtils.readFileToByteArray(f1);
    for(byte b:bytes){
        f1String=f1String+((char)b);
    }
    File temp=File.createTempFile("deleteme", "deleteme");
    byte[] newBytes=new byte[f1String.length()];
    for(int i=0; i<f1String.length(); ++i){
        char c=f1String.charAt(i);
        newBytes[i]= (byte)c;
    }
    FileUtils.writeByteArrayToFile(temp, newBytes);
    assertTrue(FileUtils.contentEquals(f1, temp));
}