Class<?> clazz=int[].class; // int[]
int mod=clazz.getModifiers();
if(Modifier.isPublic(mod)) System.out.print("public ");
if(Modifier.isAbstract(mod)) System.out.print("abstract ");
if(Modifier.isFinal(mod)) System.out.print("final ");
System.out.print(clazz);
System.out.print(" implements");
for(Class<?> cl:clazz.getInterfaces())
  System.out.print(" "+cl.getName());
System.out.println();