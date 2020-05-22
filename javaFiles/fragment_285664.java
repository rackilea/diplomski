JSONAssert.assertEquals(
        getJsonBody(expected),
        response.asString(),
        new CustomComparator(
                JSONCompareMode.LENIENT,
                new Customization("***", new RegularExpressionValueMatcher<>())
        )
);