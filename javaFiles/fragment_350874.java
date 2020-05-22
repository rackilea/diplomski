class treemap<T, U> {

   private class node {
      T word;
      int line;
      node left;
      node right;

      node(T wd, int ln){
          word=wd;
          line=ln;
      }
   }
   private node root;

   public treemap(){
       root=null;
   }