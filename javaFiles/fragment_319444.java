String line = "1_25";
String[] data1 = new String[] { "1", "26" };
String[] data2 = new String[] { "1", "25" };

String[] parts = line.split("_");
System.out.println(Arrays.equals(parts, data1));
System.out.println(Arrays.equals(parts, data2));