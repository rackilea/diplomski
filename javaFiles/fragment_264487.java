int i = (int) (new Date().getTime()/1000);
    System.out.println("Integer : " + i);
    System.out.println("Long : "+ new Date().getTime());
    System.out.println("Long date : " + new Date(new Date().getTime()));
    System.out.println("Int Date : " + new Date(((long)i)*1000L));

Integer : 1345619256
Long : 1345619256308
Long date : Wed Aug 22 16:37:36 CST 2012
Int Date : Wed Aug 22 16:37:36 CST 2012