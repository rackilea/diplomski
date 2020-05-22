else if(arr[0].equals("search")){
   if(ps.get(arr[1])!= null) {
       System.out.println(ps.get(arr[1]).toString());
       continue;
   }
   else {
        System.out.println("This name is not present. You can add it using \"enter\" command");
        }