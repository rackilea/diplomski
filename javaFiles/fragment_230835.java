public static String concatenate(List<Character> chars) {
        return chars
                .stream()
                .reduce(new StringBuilder(),
                                StringBuilder::append,
                                StringBuilder::append).toString();
    }