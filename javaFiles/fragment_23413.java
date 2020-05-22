private static String getChecksum(String s){
    int i = 14;
    byte xorChecksum = (byte)i;
    byte[] ba = s.getBytes();
    for(int j = 0; j < ba.length; j++){  
        xorChecksum ^= ba[j];  
    }
    Byte b = new Byte(xorChecksum);
    System.out.println("i: "+i+" - "+b.intValue());
    return toHex(b.intValue());
}