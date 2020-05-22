@Test
public void someMethodTestWithWildcards() throws Exception {
    MvcResult mvcResult = mockMvc.perform(put("/some/uri/with/wildcards/{foo}/{bar}", "foo", "bar"))
            .andExpect(status().isOk()).andReturn();
    Assert.assertEquals("foo and bar", mvcResult.getResponse().getContentAsString());

    mvcResult = mockMvc.perform(put("/some/uri/with/wildcards/{foo}/{bar}", "foo", null))
            .andExpect(status().isOk()).andReturn();
    Assert.assertEquals("foo and <null>", mvcResult.getResponse().getContentAsString());

    mvcResult = mockMvc.perform(put("/some/uri/with/wildcards/{foo}/{bar}", "foo", ""))
            .andExpect(status().isOk()).andReturn();
    Assert.assertEquals("foo and <null>", mvcResult.getResponse().getContentAsString());

    mvcResult = mockMvc.perform(put("/some/uri/with/wildcards/{foo}", "foo"))
            .andExpect(status().isOk()).andReturn();
    Assert.assertEquals("foo and <null>", mvcResult.getResponse().getContentAsString());
}