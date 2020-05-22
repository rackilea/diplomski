Client client = Clients.builder().build();

Application application = client.getResource(applicationHref, Application.class);

ProviderAccountRequest request = Providers.GOOGLE.account()
        .setCode(code) //where code is the value we obtained in step 8
        .build();

ProviderAccountResult result = application.getAccount(request);
System.out.println("Account Email: " + result.getAccount().getEmail());
ProviderData providerData = result.getAccount().getProviderData();
System.out.println("Access Token: " + ((GoogleProviderData)providerData).getAccessToken());