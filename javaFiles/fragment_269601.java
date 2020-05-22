clients.jdbc(dataSource).withClient("clientapp")
           .authorizedGrantTypes("password", "refresh_token")
           .authorities("USER")
           .scopes("read", "write")
           .resourceIds(RESOURCE_ID)
           .secret("123456").and().build();