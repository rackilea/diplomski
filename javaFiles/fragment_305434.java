...
int number = 6;
int result = Arrays.asList(arrayTK.replaceAll("(\\d)((?!\\1|$))", "$1;$2").split(";"))
        .stream()
        .filter(t -> t.matches(number + "+"))
        .max(Comparator.comparingInt(String::length)).get().length();