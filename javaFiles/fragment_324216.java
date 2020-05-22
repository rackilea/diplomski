mockMvc.perform(get("/persos"))
        .andExpect(status().isOk())
        .andExpect(view().name("personsPage"))
        .andExpect(
                model().attribute(
                        "personList",
                        Matchers.everyItem(AllOf.allOf(
                                HasPropertyWithValue.hasProperty("id", Is.is(1L)),
                                HasPropertyWithValue.hasProperty("name", Is.is("StackOverflow"))))));