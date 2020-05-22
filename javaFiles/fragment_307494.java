try {
    while (true) {
        String line = input.nextLine();
        int rdquo = line.indexOf('"', 1);
        String title = line.substring(1, rdquo);
        String[] avail = line.substring(rdquo+2).split(",");
        tree.insert(new Node(title, Integer.parseInt(avail[0]) , Integer.parseInt(avail[1]));
    }
} catch (NoSuchElementException reachedEndOfFile) { }