while (fileScanner.hasNext()) {
    String line = fileScanner.nextLine();
    if (line.length() == 5) { // specific length, use a constant is better          
        list.add(line);
    }
}