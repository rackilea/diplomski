public void disableCaching() {
    this.setDateHeader("Date", Time.now());
    this.setDateHeader("Expires", Time.START_OF_UNIX_TIME);
    this.setHeader("Pragma", "no-cache");
    this.setHeader("Cache-Control", "no-cache, no-store");
 }