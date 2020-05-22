@Test
public void textExistsUsername() throws Exception {
    when(userService.existsByUsername("jonki97")).thenReturn(true);
    mockMvc
            .perform(get("/checkUserData/checkUsername")
            .param("username", "jonki97"))
            .andExpect(status().isOk())
            .andExpect(content().string("false"));
}