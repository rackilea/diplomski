byte[] stringInByte=new byte[]{104,101,108,108,111};
    String simple=new String(stringInByte);
    System.out.println("simple=" + simple);//prints simple=hello

    String simple3=new String(stringInByte, "UTF-8");
    System.out.println("simple3=" + simple3);//also this prints simple=hello