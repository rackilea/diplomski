...
if (file.isFile()){
    System.out.print(file.getAbsolutePath());
    try(DigestInputStream dis=new DigestInputStream(new BufferedInputStream(new FileInputStream(file)), MessageDigest.getInstance("MD5"))){
        while(dis.read()>=0);
        System.out.println(" - MD5: "+javax.xml.bind.DatatypeConverter.printHexBinary(dis.getMessageDigest().digest()));
    }catch(Exception ex){
        System.out.println(" - Error: "+ex);
    }
} else if (file.isDirectory()){
...