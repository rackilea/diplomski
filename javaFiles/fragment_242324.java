final int size = (int) ((file.length() + LINE_BREAK_LEN) / (WORD_LEN + LINE_BREAK_LEN));
return Collections.binarySearch(
    new AbstractList<String>() {
        public String get(int pIdx) {
            try {
                file.seek((WORD_LEN + LINE_BREAK_LEN) * pIdx);
                return file.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public int size() {return size;}
    },
    target,
    Comparator.comparing(String::toLowerCase)
);