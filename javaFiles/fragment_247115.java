this.mockMvc.perform(
get("/api/v1/customers/3b658b39-4264-4995-99d8-90a1672a75a7")
   .accept(APPLICATION_JSON))
   .andExpect(status().isOk())
       .andDo(document("customer").withResponseFields(
           fieldWithPath("id").description("Unique identifier"),
           fieldWithPath("name").description("Customer full name"),
           fieldWithPath("nickname").description("How the customer wants to be called"),
           fieldWithPath("phones[].id").description("PHONE ID DESCRIPTION"),
           fieldWithPath("phones[].alias").description("PHONE ALIAS DESCRIPTION"),
           fieldWithPath("phones[].countryCode").description("PHONE COUNTRY CODE DESCRIPTION"),
           fieldWithPath("phones[].areaCode").description("PHONE AREA CODE DESCRIPTION")
           fieldWithPath("phones[].number").description("PHONE NUMBER DESCRIPTION")
        ));