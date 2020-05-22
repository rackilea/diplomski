final String bodyText=
"public Object get(Object obj) {return null;}\n"+
"public void set(Object obj, Object val) {}\n"+
"public Class getPropertyType() {return Void.class;}\n"+
"public boolean isPrimitive() {return true;}\n";

return (PropHandle)
   ClassBodyEvaluator.createFastClassBodyEvaluator(
   new Scanner(target+"__"+property, new StringReader(bodyText)),
   PropHandle.class, // Base type to extend/implement
   (ClassLoader)null); // Use current thread's context class loader