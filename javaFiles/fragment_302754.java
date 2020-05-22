bool done = false;
while (!done) {
    if (sc.hasNextDouble()) {
        values[v] = Double.parseDouble(sc.nextLine());
        v++;
    } else {
        symbols[s] = sc.nextLine();
        if (symbols[s].equals("q")) done = true;
        s++;
    }
}