@ParameterizedTest
    @CsvSource({
            "a b,+a +b",
            "a (b c),+a +(+b +c)",
            "a|b,(a b)",
            "a|b|c,(a b c)",
            "aa|bb|(cc|(ff gg)) hh,+(aa bb (cc (+ff +gg))) +hh",
            "(aa(bb(cc|ee)|ff) gg),(+aa(bb(cc ee) ff) +gg)",
            "(a b),(+a +b)",
            "(a(c|d) b),(+a(c d) +b)",
            "bb(cc|ee),bb(cc ee)",
            "((a|b) (a b)|b (c|d)|e),(+(a b) +((+a +b) b) +((c d) e))"
    })
    void testTransformString(String input, String output) {
        Assertions.assertEquals(output, transformString(input));
    }

    @ParameterizedTest
    @CsvSource({
            "a b,+a +b",
            "a b c,+a +b +c",
            "a|b,(a b)",
            "(a b),(+a +b)",
            "(a|b),(a b)",
            "a|b|c,(a b c)",
            "(aa|bb cc|dd),(+(aa bb) +(cc dd))",
            "(aa|bb|ee cc|dd),(+(aa bb ee) +(cc dd))",
            "aa|bb|cc|ff gg hh,+(aa bb cc ff) +gg +hh"
    })
    void testTransformBasic(String input, String output) {
        Assertions.assertEquals(output, transformBasic(input));
    }