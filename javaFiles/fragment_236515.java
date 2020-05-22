mockMvc.perform(get("/feed")
           .sessionAttr("loginStatus", true)
           .sessionAttr("userId", 1234l))
                .andExpect(status().isOk())
                .andExpect(view().name("posts/feed"))
                .andExpect(model().attributeExists("posts"));