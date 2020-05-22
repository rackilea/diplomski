Cookie userNameCookie = new Cookie.Builder("username", "some_value")
                .setSecured(true)
                .setComment("some comment")
            .build();
Cookie pwdCookie = new Cookie.Builder("password", "some_value")
                .setSecured(true)
                .setComment("some comment")
            .build();
Cookies cookies = new Cookies(userNameCookie, pwdCookie);

Response response = given().port(port).cookies(cookies).when().get("request URL");