public static Iterator<String> iterateValues(String text) {
    return new Iterator<String>() {
        int start = 0;
        Stack<Character> generics = new Stack<>();

        @Override
        public boolean hasNext() {
            return start <= text.length();
        }

        @Override
        public String next() {
            for (int i = start; i < text.length(); i++) {
                char c = text.charAt(i);
                switch (c) {
                    case '<':
                        generics.push(c);
                        break;
                    case '>':
                        if (generics.isEmpty() || generics.pop() != '<') {
                            throw new IllegalArgumentException("Invalid generic type constraints");
                        }
                        break;
                    case ',':
                        if (generics.isEmpty()) {
                            String result = text.substring(start, i);
                            start = i + 1; //move window
                            return result;
                        }
                        break;
                }
            }
            String result = text.substring(start);
            start = text.length() + 1; //move window
            return result;
        }
    };
}