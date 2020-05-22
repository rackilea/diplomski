request = OAuthClientRequest.tokenLocation("https://www.linkedin.com/uas/oauth2/accessToken")
                    .setGrantType(ResponseType.CODE.toString())
                    .setCode("****")
                    .setRedirectURI("https://www.example.in")
                    .setClientId("*******")
                    .setClientSecret("******").buildBodyMessage();