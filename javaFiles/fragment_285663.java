String expected = "{\n" +
        "  \"timestamp\": \"^\\\\d{4}-\\\\d{2}-\\\\d{2}T\\\\d{2}:\\\\d{2}:\\\\d{2}\\\\.\\\\d{3}\\\\+\\\\d{4}$\",\n" +
        "  \"status\": 415,\n" +
        "  \"error\": \"Unsupported Media Type\",\n" +
        "  \"message\": \"Content type 'text/plain;charset=ISO-8859-1' not supported\",\n" +
        "  \"path\": \"/service/addUser\"\n" +
        "}";
String actual = "{\n" +
        "  \"timestamp\": \"2018-11-13T04:12:55.923+0000\",\n" +
        "  \"status\": 415,\n" +
        "  \"error\": \"Unsupported Media Type\",\n" +
        "  \"message\": \"Content type 'text/plain;charset=ISO-8859-1' not supported\",\n" +
        "  \"path\": \"/service/addUser\"\n" +
        "}";
JSONAssert.assertEquals(
        expected,
        actual,
        new CustomComparator(
                JSONCompareMode.LENIENT,
                new Customization("***", new RegularExpressionValueMatcher<>())
        )
);