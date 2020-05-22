private static Consumer<Integer> printWithPrefix(String prefix,
                                                 Consumer<Integer> printer) {
    return number -> {
        System.out.print(prefix);
        printer.accept(number);
    };
}