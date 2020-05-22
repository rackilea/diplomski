try {
      Log.d(TAG, "Trying to get the input stream..");
      iStream=c.getInputStream();
    } catch (Exception e) {
      e.printStackTrace();
      iStream=c.getErrorStream();
}