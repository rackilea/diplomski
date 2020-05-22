final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0aWQiOiJiZWJlMjM4Zi1iMGM4LTQwYzMtOTYyMC1jZDRlOGUyMzIwZGMiLCJvaWQiOiI5MjJjMmZiNC0zNWI1LTExZDctOWE2NC0wMGIwZDBmY2I5ZTMiLCJzdWIiOiI5MjJjMmZiNC0zNWI1LTExZDctOWE2NC0wMGIwZDBmY2I5ZTMiLCJlbWFpbCI6InRlc3RAdGVzdC5jb20iLCJpYXQiOjE1MTg0NDk5NzYsImV4cCI6MTUxODQ1MzU3NiwibmJmIjoxNTE4NDQ5OTc2fQ.6InknrU67g_HEkaLxD9Ul5vOzbYGf54mJNcSyPr-xek";
        final DecodedJWT decodedJwt = JWT.decode(token);
        System.out.println("Header =  " + decodedJwt.getHeader());
        System.out.println("Algorithm =  " + decodedJwt.getAlgorithm());
        System.out.println("Audience =  " + decodedJwt.getAudience());
        decodedJwt.getClaims().forEach((k, v) -> {
            System.out.println("Claim " + k + " = " + v.asString());
        });
        System.out.println("ContentType =  " + decodedJwt.getContentType());
        System.out.println("ExpiresAt =  " + decodedJwt.getExpiresAt());
        System.out.println("Id =  " + decodedJwt.getId());
        System.out.println("Issuer =  " + decodedJwt.getIssuer());
        System.out.println("Subject =  " + decodedJwt.getSubject());