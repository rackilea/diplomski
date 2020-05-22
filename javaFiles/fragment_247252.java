@Test
@WithMockUser(username = "username", roles={"ADMIN"})
public void testGetMarkupAgent() throws Exception {

    mockMvc.perform(get("/myurl"))
            .andExpect([...]);
}