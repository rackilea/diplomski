public static void createNewSpike(int x, int y) 
{
    Application.postRunnable(new Runnable(){
        public void run(){
            sb.draw(spike.spikeLeft, x, y);
        }
    });

}