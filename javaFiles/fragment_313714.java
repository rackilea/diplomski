String str = parent.getAdapter().getItem(position).toString();
String[] parts = str.split("---");
String part1 = parts[0]; 
String part2 = parts[1]; // This is the part you want
String output = part2.replaceAll("\\s+","") //trim whitespace
String output2 = output.replace("}", ""); // remove the "}" character
System.out.println(output2);