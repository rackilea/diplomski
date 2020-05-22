long startTime = System.currentTimeMillis();
// .....
// processing request
// .....
long endTime = System.currentTimeMillis();
long differenceTime = endTime - startTime;
log.debug("Request time: " + differenceTime);
//or
log.debug("Request time: " + TimeUnit.MILLISECONDS.toSeconds(differenceTime) + " sec");