this.mockMvc.perform(get(API_COMPANY + id))
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_UTF8))
            .andExpect(jsonPath("id", is(1)))
            .andExpect(jsonPath("$.name", is("Google")))
            .andExpect(jsonPath("$.products", hasSize(2)))
            .andExpect(jsonPath("$.products[*].id", Matchers.containsInAnyOrder(1, 2)))
            .andExpect(jsonPath("$.products[*].name", Matchers.containsInAnyOrder("search engine", "adv.")))
            .andExpect(jsonPath("$.products[*].company").doesNotExist());