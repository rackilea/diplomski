try {
  myMethodThatThrows();
} catch (Exception e) {
  Crashlytics.logException(e);
  // handle your exception here! 
}