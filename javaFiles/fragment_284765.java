Jwt jwt = Jwt.withTokenValue("token")
        .header("alg", "none")
        .claim("scope", "message:read")
        .build();
when(jwtDecoder.decode(anyString())).thenReturn(jwt);
mockMvc.perform(post("/message")
        .content("Hello message")
        .header("Authorization", "Bearer " + jwt.getTokenValue()))
        .andExpect(status().isOk())
        .andExpect(content().string(is("Message was created. Content: Hello message")));