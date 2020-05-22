GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, clientId, clientSecret,
            Arrays.asList(CalendarScopes.CALENDAR)).setAccessType("online")
                .setApprovalPrompt("auto").build();

String url = flow.newAuthorizationUrl().setRedirectUri(redirectUrl).build();
System.out.println("Please open the following URL in your browser then type the authorization code:");

System.out.println("  " + url);
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String code = br.readLine();

GoogleTokenResponse response = flow.newTokenRequest(code)
                .setRedirectUri(redirectUrl).execute();
GoogleCredential credential = new GoogleCredential()
                .setFromTokenResponse(response);

// Create a new authorized API client
Calendar service = new Calendar.Builder(httpTransport, jsonFactory,
                credential).build();