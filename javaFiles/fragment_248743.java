String line = "";
while ((line = inFromClient.readLine()) != null) {
    System.out.println(line);
    sb.append(line);
    sb.append('\n');
}