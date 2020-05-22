@Test
@WithUserDetails("usernameThatIsFoundByUserDetailsService")
public void run() throws Exception {
    MvcResult result = mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .etc;
}