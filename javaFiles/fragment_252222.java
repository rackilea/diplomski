// no need to set delimiter
while (scanner.hasNextLine()) {
    String line = scanner.nextLine().replaceAll("^((?:\\+|-)?\\d+)->((?:\\+|-)?\\d+)->((?:\\+|-)?\\d+)$", 
                                                "$1 -> $2 costs $3");
    System.out.println(line);
}