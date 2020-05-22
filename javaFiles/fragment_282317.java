String s="2014/03/31 14:52";
     String s1=s.substring(11, s.length());


     System.out.println(s1);
    String s2[]=s1.split(":");

    if(Integer.parseInt(s2[0])>=13 && Integer.parseInt(s2[1])>0){

        System.out.println("Here apply your logic");


    }