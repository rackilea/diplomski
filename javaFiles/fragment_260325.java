String host="www.google.com";
String request="GET / HTTP/1.0\r\nHost: "+host+"\r\nAccept-Encoding: gzip\r\n\r\n";
System.out.println(request);
Socket sock=new Socket(host,80);
InputStream inp=sock.getInputStream();
OutputStream outp=sock.getOutputStream();
outp.write(request.getBytes());
byte[] buff=new byte[999];
while(true){
    int n=inp.read(buff);
    if(n<0) break;
    System.out.println(new String(buff,0,n));
}
inp.close();
outp.close();
sock.close();