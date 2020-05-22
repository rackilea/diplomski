serverAddr = InetAddress.getByName(ipAddress);


soc=new Socket(serverAddr,8210);
try {
    outStream=soc.getOutputStream();
    while(send)
    {
        outStream.write(data);
    } 
    outStream.close();
} finally {
    soc.close();
}