mockMvc.perform(post(YOUR_URL).contentType(APPLICATION_FORM_URLENCODED)
    .param(...)
    .param(...)
    .andExpect(model().hasErrors())
    .andExpect(model().attributeHasFieldErrors(FORM_MODEL_NAME, "field"))
    .andExpect(model().attributeHasFieldErrorCode(FORM_MODEL_NAME, "anotherfield", "error")
    .andExpect(view().name(YOUR_VIEW));