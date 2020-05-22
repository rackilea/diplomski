//firstElement only exists to force the caller to provide at least one element
//if you don't want this then just use the varargs array
A(T firstElement, T... furtherElements){      
  int length = 10;
  Class<?> elementClass = furtherElements.getClass().getComponentType();      
  datas  = (T[])Array.newInstance( elementClass, length);
}