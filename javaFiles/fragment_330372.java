public static String transform(final List<String> list) {

    return list.stream()
            .filter(p -> p.matches(".*\\d.*"))
            .reduce((a,b) -> {
                if (Integer.parseInt(a.replaceAll("\\D+", "")) > Integer.parseInt(b.replaceAll("\\D+", ""))) {
                    return a;
                } else {
                    return b;
                }
            })
            .orElse("there are no numbers");
}