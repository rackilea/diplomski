try{
   load(fname);
}catch(Exception e){
   try{
      load(alternativeFName);
   }catch(Exception e){
      System.out.println("None of the files are available");
      e.printStackTrace();
   }
}