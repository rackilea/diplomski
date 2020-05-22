InetAddress ip = InetAddress.getByName("www.fake.cao");

InetAddress fake;
try {
   fake = InetAddress.getByName("does-not-exist.invalid");      
} catch (UnknownHostException e) {
   //www.fake.cao exists, but invalid does not
   return ip;
} 
if (Arrays.equals(ip.getAddress(),fake.getAddress())) {
    //both ip and fake resolves to the same IP
    throw new UnknownHostException();
}

//invalid does exist, but it is different from ip
return ip;