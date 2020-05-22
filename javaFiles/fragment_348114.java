char[] coords = "000175001022".toCharArray();

StringBuilder sb = new StringBuilder();
sb.append("( ");
sb.append(coords, 0, 6);
sb.append(", ");
sb.append(coords, 6, 6);
sb.append(" )");
System.out.println(sb); // prints ( 000175, 001022 )