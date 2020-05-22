List<String> view = logData1;
int emailIndex;
while ((emailIndex = Collections.lastIndexOfSubList(view, toFind)) >= 1) {
  logData1.subList(emailIndex-1, emailIndex+3).clear();
  view = logData1.subList(0, emailIndex-1);
}