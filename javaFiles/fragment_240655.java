public Object coerce(Object value, Class<?> coerceTo) {
    if (Boolean.class.equals(coerceTo)) {
        //coerce soap primitive to Boolean
    }
    else if (Integer.class.equals(coerceTo)) {
        //coerce soap primitive to Integer
    }
    else if (List.class.equals(coerceTo)) {
      return Collections.singletonList(coerce(value, coerceTo.getTypeParameters()[0]));
    }
}