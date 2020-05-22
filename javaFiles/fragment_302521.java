this.mockMvc
  .perform(post("/authenticate")
    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
    .param("username", "user@example.com")
    .param("password", "superSecretPassword"))
  .andExpect(status().isOk())
  .andDo(document("preprocessed-request",
    preprocessRequest(maskPassword())));