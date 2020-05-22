.andExpect(MockMvcResultMatchers.jsonPath("$longvalue")
        .value(Matchers.isA(Number.class)))
.andExpect(MockMvcResultMatchers.jsonPath("$longvalue")
        .value(Matchers.anyOf(
            Matchers.equalTo((Number) id),
            Matchers.equalTo((Number) id.intValue()))));