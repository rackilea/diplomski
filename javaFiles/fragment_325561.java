Class cls = obj.getClass();        
    for (Class acls = cls; acls != null; acls = acls.getSuperclass()) {
      try {
        Field field = acls.getDeclaredField(fieldName);
        // if not found exception thrown
        // else return field
        return field;
      } catch (NoSuchFieldException ex) {
        // ignore
      }
    }