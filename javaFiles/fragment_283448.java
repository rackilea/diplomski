ServletContext servletContext = servletContextEvent.getServletContext();
try{
 // create the timer and timer task objects
  Timer timer = new Timer();
  MyTimerTask task = new MyTimerTask(); //this class implements Callable.

 // get a calendar to initialize the start time
  Calendar calendar = Calendar.getInstance();
 Date startTime = calendar.getTime();

  // schedule the task to run hourly
 timer.scheduleAtFixedRate(task, startTime, 1000 * 60 * 60);

  // save our timer for later use
  servletContext.setAttribute ("timer", timer);
} catch (Exception e) {
 servletContext.log ("Problem initializing the task that was to run hourly: " + e.getMessage ());
}