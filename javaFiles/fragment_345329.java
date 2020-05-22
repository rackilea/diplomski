private static Pattern test_pattern = Pattern
        .compile("^(?=[A-Z#]{35}$)[A-Z]+##[A-Z]+#[A-Z]+#+$");

private static boolean test(String test_line) {
    return test_pattern.matcher(test_line).matches();
}