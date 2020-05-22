private static int[] lineToInts(String line) {
    int semicolons = 0;
    for (int i = 0; (i = line.indexOf(';', i)) != -1; ++i) {
        ++semicolons;
    }
    int[] b = new int[semicolons + 1];
    int pos = 0;
    for (int i = 0; i < b.length(); ++i) {
        int pos2 = line.indexOf(';', pos);
        if (pos2 < 0) {
            pos2 = line.length();
        }
        b[i] = Integer.parseInt(line.substring(pos, pos2));
        pos = pos2 + 1;
    }
    return b;
}