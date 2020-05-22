String inputLine;
StringBuilder sb = new StringBuilder();
while ((inputLine = in.readLine()) != null) {
    sb.append(inputLine).append("\n");
}
System.out.println(sb);