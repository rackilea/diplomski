public static long countUpperCase(final String str) {
        return str
                .chars() // get all chars from the argument
                .filter(c -> Character.isUpperCase(c)) // filter only the uppercase
                .count(); // count the uppercase
    }