String line;
while ((line = din.readLine()) != null) {
    System.out.println("Read " + line);
    if (line.length() == 0) {
        break;
    }
}