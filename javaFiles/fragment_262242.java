class SortByConsonants implements Comparator<String> {

    public int compare(String a, String b) {
        if (count(a) - count(b) == 0) {
            return 1;
        }
        return count(a) - count(b);
    }

    public boolean equals(String a, String b) {
        return a.equals(b);
    }

    public int count(String line) {
        int consonants = 0;
        line = line.toLowerCase();
        for (int i = 0; i < line.length(); ++i) {
            char ch = line.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                consonants++;
            }
        }
        return consonants;
    }

}