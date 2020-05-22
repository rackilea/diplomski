final int [] result = new int[1]; // Create a final array
TimerTask time =  new TimerTask() { 
       int sec = 0; 
        public void run()
        {
            sec++;
            result[0] = sec;
        }
    };
 // Now Print whenver you want it
 System.out.println(result[0]);