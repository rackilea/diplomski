BufferedInputStream in = new BufferedInputStream(sktClient.getInputStream());
byte[] contents = new byte[1024];

int bytesRead = 0;
String strFileContents; 
while((bytesRead = in.read(contents)) != -1) { 
    strFileContents += new String(contents, 0, bytesRead);              
}

System.out.print(strFileContents);