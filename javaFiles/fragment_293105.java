@Test
    public void textExistsUsername() throws Exception {
        mockMvc
                .perform(get("/checkUserData/checkUsernameAtRegistering")
                .param("username", "jonki97"))
                .andExpect(status().isOk());
    }