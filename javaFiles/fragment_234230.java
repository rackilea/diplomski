Object o = ...;
Class c = o.getClass();
Annotation[] as = c.getAnnotations();
for (Annotation a : as) {
   // prints out the proxy class name
   System.out.println(a.getClass().getName());
   // prints out the name of the actual annotation
   System.out.println(a.annotationType().getName());
}