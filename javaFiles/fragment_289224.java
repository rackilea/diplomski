public void logStaticFields( Class<?> clazz) throws IllegalAccessException {
  for( Field f : clazz.getDeclaredFields() ) {
    if( Modifier.isStatic( f.getModifiers() ) ) {
      boolean wasAccessible = f.isAccessible();
      f.setAccessible(true);
      Log.i (TAG, "this is debug output of static field " + f.getName() + ": " + f.get( null ) );
      f.setAccessible( wasAccessible );
    }
  }
}