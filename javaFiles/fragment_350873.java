class treemap<String, Integer> {

   private class node {
      String word;
      int line;
      node left;
      node right;

      node(String wd, int ln){
          word=wd;
          line=ln;
      }
   }
   private node root;

   public treemap(){
       root=null;
   }