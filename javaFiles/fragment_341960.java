@Test
public void testCreateUser() throws Exception {
    mockMvc.perform(post("/api/create")
        .accept(MediaType.APPLICATION_JSON)
        .header("AUTH_TOKEN", TOKEN)
        .content(ObjectToJsonUtil.convertObjectToJsonBytes(user)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.*", Matchers.hasSize(1)));
}