String input = "vhigh,vhigh,2,2,small,low,unacc";

String[] inputParts = input.split(",");
String firstSix = String.join(",", Arrays.copyOfRange(inputParts, 0, 6));
String last = inputParts[6];

System.out.println(firstSix);
System.out.println(last);