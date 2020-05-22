...
if (file.isFile()){
    System.out.print(file.getAbsolutePath());
    MessageDigest md5=null;
    try{md5=MessageDigest.getInstance("MD5");}catch(NoSuchAlgorithmException nsae){};
    try(DigestInputStream dis=new DigestInputStream(new BufferedInputStream(new FileInputStream(file)), md5)){
        while(dis.read()>=0);
        System.out.print(" - MD5: ");
        for(Byte b: md5.digest())
            System.out.printf("%02X",b);
        System.out.println();
    }catch(IOException ioe){
        System.out.println(" - Error: "+ioe);
    }
} else if (file.isDirectory()){
...