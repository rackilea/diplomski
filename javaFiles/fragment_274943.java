rtime = Integer.parseInt(String.valueOf(prev.getTime())); // on first run will raise warning
delay = Integer.parseInt(vars.get("delay"));    

Integer sleep = delay - rtime;

log.info( "Sleep for " + sleep.toString() + " milli-seconds" );
return sleep;