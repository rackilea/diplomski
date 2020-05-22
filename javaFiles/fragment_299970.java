try{
     parse = Integer.parseInt(choice);
      }
    catch(Exception e){
        System.out.println("Please enter a valid integer"); 
        return;  // <--- change this to "continue;"
    }