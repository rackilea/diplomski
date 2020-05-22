String lower="620/75R38";
   String upper= "1050/50R38";

   String str="50/65R38";


   if(str.compareTo(lower)>0 && upper.compareTo(str)<0){
       System.out.println("inside the range");
   }