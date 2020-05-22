byte[] stringInByte1=new byte[]{104,101,108,108,111,32,(byte)164};
    String simple1=new String(stringInByte1,"ISO8859-15");
    System.out.println("simple1=" + simple1);//prints simple1=hello

    String simple4=new String(stringInByte1, "UTF-8");
    System.out.println("simple4=" + simple4);//prints simple4=hello ?