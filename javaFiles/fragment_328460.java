// test commutativity
assertEquals("0", multiplier.multiply("0", "5"));
assertEquals("-1", multiplier.multiply("1", "-1"));
assertEquals("149645", multiplier.multiply("173", "865"));
assertEquals("149645", multiplier.multiply("865", "173"));

// test some more unusual cases of multiplying with 0
assertEquals("0", multiplier.multiply("-5", "0"));
assertEquals("0", multiplier.multiply("0", "-0"));
// test with numbers starting with '+'
assertEquals("368", multiplier.multiply("+23", "+16"));
assertEquals("-368", multiplier.multiply("-23", "+16"));

// test multiplying huge values without overflow
assertEquals("18446744073709551616", multiplier.multiply("4294967296", "4294967296"));
assertEquals("18446744073709551616", multiplier.multiply("-4294967296", "-4294967296"));