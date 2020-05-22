public static void main(String[] args) {
    final String pattern = "(?![_-])(?!(?:.*[_-]){2,})[A-Za-z_-]{1,14}";
    final String[] tests = {
            "Hello-Again",
            "ThisIsValid",
            "AlsoThis_",
            "_NotThis_",
            "-notvalid",
            "Not-Allow-This",
            "Nor-This_thing",
            "VeryVeryLongStringIndeed",
    };
    for (final String test : tests) {
        System.out.println(test.matches(pattern));
    }
}