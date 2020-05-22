byte[] stringInByte1=new byte[]{104,101,108,108,111,32,(byte)164};
    String simple1=new String(stringInByte1,"ISO8859-15");
    System.out.println("simple1=" + simple1);  //prints simple1=hello €     

    String simple2=new String(stringInByte1,"ISO8859-1");
    System.out.println("simple2=" + simple2);   //prints simple1=hello ¤