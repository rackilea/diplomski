public void searchEntry(String name) {

   for(int i = 0; i < directory.length; i++) { 
    if(directory[i] != null) {

       if(directory[i].getName().equals(name)){
         System.out.println(directory[i]); 
         break; // assuming name is unique so you don't need to continue looping once name is found
       }
    }else {
            System.out.println("no entry");
    }
   }
 }