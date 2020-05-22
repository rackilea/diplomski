MockHttpSession session = new MockHttpSession();
    session.setAttribute("token", token);

    MvcResult result = this.mockMvc.perform(get("/rest/login").session(session)
            .header("X-Csrf-Token", "")
            .requestAttr(CsrfToken.class.getName(), token)
            .param("name", name)
            .param("password", password)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andReturn();