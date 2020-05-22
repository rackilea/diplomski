String s;   

    while(res1.next()){
       s=res1.getString(1);
    }

  String [] splitted = s.split(" ");
   for(String aSplit: splitted){
        System.out.println(aSplit);
   }