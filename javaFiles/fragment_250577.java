int fc = s.length;


   if(fc == 1){
       System.out.println("String accepted under rule a*");
   }
   if(fc == 2 || fc == 4){
       System.out.println("String accepted under rule a*b+");
   }
   if(fc >= 5 ){
        System.out.println("String accepted under rule abb");
   }