public void resume() {
   System.out.println("Resumed");

   pause = false;
   for(MyRecursive mr : list) {
      if(mr != null)
         mr.resume();
      }
   }
}