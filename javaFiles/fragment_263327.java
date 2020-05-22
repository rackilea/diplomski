Test example = new Test();
System.out.println(example.getSample()); // Prints: 1337
example = new Test(-1);
System.out.println(example.getSample()); // Prints: -1
example.setSample(12345);
System.out.println(example.getSample()); // Prints: 12345