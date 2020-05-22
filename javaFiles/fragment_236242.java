public void update(Observable o, Object arg) {
  try{
    Method update = getClass().getMethod(o.getClass(), Object.class);
    update.invoke(this, o, arg);
  } catch(Exception e) {
    // log exception
  }
}