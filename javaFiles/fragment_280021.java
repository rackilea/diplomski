public void setter(String name, LinkedList value) throws IllegalArgumentException {
    try {
      Field field = getClass().getDeclaredField(name);
      field.setAccessible(true);
      field.set(this, value);
      field.setAccessible(false);
    } catch (NoSuchFieldException | IllegalAccessException e) {}
  }

  public LinkedList getter(String name) {
    LinkedList ret = null;
    try {
      Field field = getClass().getDeclaredField(name);
      field.setAccessible(true);
      Object object = field.get(this);
      if (object instanceof LinkedList) {
        ret = (LinkedList) object;
      }
      field.setAccessible(false);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return ret;
  }