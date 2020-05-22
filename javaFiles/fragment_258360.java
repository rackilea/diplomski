try {
   //stuff
} catch (IOException e) {
   log.error("Failed to do stuff", e);
   throw e;
}