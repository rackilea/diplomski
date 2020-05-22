String[] rows = {"AAA","BBB","CCC"};
StringBuilder sb = new StringBuilder();
for(String row : rows) {
    sb.append(row);
}
System.out.println(sb.charAt(6));  // C