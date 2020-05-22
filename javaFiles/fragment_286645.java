URL url = new URL(URBAN_AIRSHIP_API_URL);
        HTTPRequest req = new HTTPRequest(url, HTTPMethod.POST);

        String authString = ApplicationProperties.getUrbanAirshipAppId() + ":" + ApplicationProperties.getUrbanAirshipMasterSecret();

        String authStringBase64 = new String(Base64.encodeBase64(authString.getBytes()));
        authStringBase64 = authStringBase64.trim();

        req.addHeader(new HTTPHeader("Content-Type", "application/json"));
        req.addHeader(new HTTPHeader("Authorization", "Basic " + authStringBase64));

        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        mapper.writeValue(byteStream, new PushNotificationObj(userEmail, message));

        req.setPayload(byteStream.toByteArray());