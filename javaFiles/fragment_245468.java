@Test
  public void textError() throws Exception {
    when(userService.getUserAttributes(anyInt())).thenThrow(new RuntimeException()).thenReturn(null);
    this.mockMvc.perform(get("/user/xxx")
            .accept("application/xml"))
            .andExpect(status().isBadRequest());
  }