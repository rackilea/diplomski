private long EnabledAfter  = 300000; // 5 minutes
private long DisabledAfter = 30000;  // 30 seconds

private Runnable Enabler = new Runnable() {
    public void run() {                                                     
        something.enable(context);                          
        something.enable_else(context, true);       

        Handler.postDelayed(Disabler, DisabledAfter);
    }
};

private Runnable Disabler = new Runnable() {
    public void run() {
        something.disable(context);                                 
        something.disable_else(context, false); 

        Handler.postDelayed(Enabler, EnabledAfter);              
    }
};

public void start_timers(){
    Handler.postDelayed(Enabler, EnabledAfter);
}//end method

public void stop_timers(){
   Handler.removeCallbacks(Enabler);
   Handler.removeCallbacks(Disabler);
}//end method