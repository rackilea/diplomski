StringBuilder sb = new StringBuilder();
String temp;
while ((temp = br.readLine()) != null) {
    sb.append(temp).append("\n");
    System.out.println(temp);
}
String html = sb.toString();