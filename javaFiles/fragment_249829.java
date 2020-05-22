try {
      Resources res = getResources();
      InputStream in_s = res.openRawResource(R.raw.yourfile);

      byte[] b = new byte[in_s.available()];
      in_s.read(b);
      String str = new String(b);
    } catch (Exception e) {
      Log.e(LOG_TAG, "File Reading Error", e);
 }