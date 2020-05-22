public void doAttackAnimation(){
   new Thread(()-> {
         setIcon("Your Attack Animation");
         sleep(durationOfAnimation);
         setIcon("default Animation");
      }).start();
}