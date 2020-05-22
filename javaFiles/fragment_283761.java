mockMvc.perform(
    post("/person/save", new Object[0])
        .param("firstName", "JunitFN")
        .param("lastName", "JunitLN")
        .param("gender", "M")
        .param("dob", "11/02/1989")
 ).andExpect(
        redirectedUrlPattern("view/[0-9]+")
 );