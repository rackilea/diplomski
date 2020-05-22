MockMvc mvc = MockMvcBuilders.webAppContextSetup(wac).build(); // was is a web application context.
MvcResult result = mvc
            .perform(
                    get("/autocomplete")
            .accept(
                    MediaType.APPLICATION_JSON))
            .andExpect(status().isOk()).andReturn();
String content = result.getResponse().getContentAsString();  // verify the response string.