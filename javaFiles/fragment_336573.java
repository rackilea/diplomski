private void destroyMe(String destroyMe) {
    try {
      int len = destroyMe.length();
      Field f = destroyMe.getClass().getDeclaredField("value");
      f.setAccessible(true);
      char[] stars = new char[len];
      Arrays.fill(stars, '*');
      f.set(destroyMe, stars);
      f.setAccessible(false);
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
  }