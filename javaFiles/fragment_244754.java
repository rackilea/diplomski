438  /**
439   * Determine if a class is a root resource class.
440   *
441   * @param c the class.
442   * @return true if the class is a root resource class, otherwise false
443   *         (including if the class is null).
444   */
445  public static boolean isRootResourceClass(Class<?> c) {
446      if (c == null)
447          return false;
448      
449      if (c.isAnnotationPresent(Path.class)) return true;
450  
451      for (Class i : c.getInterfaces())
452          if (i.isAnnotationPresent(Path.class)) return true;
453  
454      return false;
455  }