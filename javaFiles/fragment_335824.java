new Thread(){
   public void run(){
     AnimationDrawable.start();
   }
}.start();

for (int i = 0 ; i< 10000000 ; i ++){
   System.out.println(i);
}