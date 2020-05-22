String left = "Jörn"; 
System.out.println(GraphLayout.parseInstance(left).totalSize()); // 48 bytes

String right = "foobar";
System.out.println(GraphLayout.parseInstance(right).totalSize()); // 48 bytes

String oneMore = "\u03b1";
System.out.println(GraphLayout.parseInstance(oneMore).totalSize()); // 48 bytes