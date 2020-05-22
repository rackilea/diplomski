Class objectClass = o.getClass();
Class superClass = thisClass.getSuperclass();
Package objectPackage = objectClass.getPackage();
Package superPackage = superClass.getPackage();
System.out.println("--begin--");
System.out.println("Object: " + objectClass);
System.out.println("objectPackageName: " + objectPackage.getName());
System.out.println("Super: " + superClass);
System.out.println("superPackageName: " + superPackage.getName())