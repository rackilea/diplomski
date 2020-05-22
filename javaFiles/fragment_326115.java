Handler handler = new Handler();
Runnable[] eRunnables = new Runnable[enemies.length-1];

for(int i = 0; i < eRunnables.length; i++){
   eRunnables[i] = new Runnable(){
        public void run(){
            if(enemies[i].getVisibility() == View.VISIBLE){
                health2--;
                health.setText("Health:" + health2);
                handler.postDelayed(eRunnables[i], 1000);
            }    
        }
    };
}