Scanner scanner = new Scanner("0|0.20\n1|0.10\n2|0.20\n");
scanner.useDelimiter(Pattern.compile("[|\n]"));
System.out.println(scanner.nextInt());
System.out.println(scanner.nextDouble());
System.out.println(scanner.nextInt());
System.out.println(scanner.nextDouble());