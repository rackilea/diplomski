i1 = new IntegSet(0, 2);
i2 = new IntegSet(i1);

System.out.println("i1: " + Arrays.toString(i1.getData()));
System.out.println("i2: " + Arrays.toString(i2.getData()));
i1.getData()[2] = false;
System.out.println("i1: " + Arrays.toString(i1.getData()));
System.out.println("i2: " + Arrays.toString(i2.getData()));