Calendar sessionEndTime = logSession.getStartTime();
sessionEndTime.add(Calendar.MINUTE, TIMEOUT_MINS);
Calendar currentSysTime = Calendar.getInstance();
if (currentSysTime.after(sessionEndTime)) {
//do something
}