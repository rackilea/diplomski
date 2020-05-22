String[]   o1 = new String[2];      // Yes, it's one-dimensional
String[][] o2 = new String[2][];    // No, it isn't
Object[]   o3 = new Object[2];      // It may or may not be, depending on contents
Object[]   o4 = new Object[2];      // It may or may not be, depending on contents

// This makes `o3` multi-dimensional
o3[0] = new Object[0];
System.out.println(isOneDimensional(o1));   // true
System.out.println(isOneDimensional(o2));   // false
System.out.println(isOneDimensional(o3));   // false
System.out.println(isOneDimensional(o4));   // true