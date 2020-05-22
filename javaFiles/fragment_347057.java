java.lang.reflect.Method method;
try {
  for(int i=1; i<54; i++){
       method = summary.getClass().getMethod("setPeriod_"+i, BigDecimal.class);
       method.invoke(summary, object[i]);
  }
} catch (SecurityException e) { ... }
  catch (NoSuchMethodException e) { ... }
  catch (IllegalArgumentException e) { ... }
  catch (IllegalAccessException e) { ... }
  catch (InvocationTargetException e) { ... }