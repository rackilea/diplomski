public void playMet()
{
    Thread t = new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            while(Play.isSelected()){
                //Your code
            }
        }
    };
    t.start();
}