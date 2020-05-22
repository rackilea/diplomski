Class c = o.getClass();
Class[] theInterfaces = c.getInterfaces();
for (int i = 0; i < theInterfaces.length; i++) {
   String interfaceName = theInterfaces[i].getName();
   System.out.println(interfaceName);
}