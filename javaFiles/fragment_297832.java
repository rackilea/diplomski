File file = new File(yourFileName);
FileInputStream fis = new FileInputStream(file);
byte[] data = new byte[(int) file.length()];
fis.read(data);
fis.close();
String strData=new String(data, "UTF-8"); // converting byte array to string
System.out.println(strData);