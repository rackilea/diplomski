File testfile = new File("test.txt");
StringBuilder stringBuffer = new StringBuilder();
try{
    BufferedReader reader =  new BufferedReader(new FileReader(testfile));
    char[] buff = new char[500];
    for (int charsRead; (charsRead = reader.read(buff)) != -1; ) {
        stringBuffer.append(buff, 0, charsRead);
    }
}
catch(Exception e){
    System.out.print(e);
}
System.out.println(stringBuffer);