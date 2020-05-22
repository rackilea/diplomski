private static void products2(final String products) {
    final String regex = "\\{([0-9]+),([0-9]+)\\}";

    if (products.split(regex).length > 0) {
        throw new IllegalArgumentException("Wrong semantic of products!");
    }

    final Matcher matcher = Pattern.compile(regex).matcher(products);
    while (matcher.find()) {
        System.out.print(matcher.group(1) + " ");
        System.out.println(matcher.group(2));
    }
}