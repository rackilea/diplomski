try {
    mockMvc.perform(post(URL_EXPERIENCES).principal(authentication)
        .content(json(experience)).contentType(CONTENT_TYPE))
        .andExpect(status().isForbidden());
    Assert.fail();
} catch (Exception e) {
    Assert.assertTrue(e.getCause() instanceof AccessDeniedException);
}