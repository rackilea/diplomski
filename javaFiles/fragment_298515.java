// before
for (boolean b : doors)
    System.out.println(b);

// after
for (boolean b : doors)
    System.out.print(b ? '1' : '0');
System.out.println();