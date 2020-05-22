APIContext defaultContext = new APIContext(clientId1, clientSecret1, "sandbox");
APIContext sandboxContext = new APIContext(clientId2, clientSecret2, "sandbox");
APIContext someOtherContext = new APIContext(clientId3, clientSecret3, "live");
APIContext liveContext = new APIContext(clientId, clientSecret, "live");

// Now pass any of the above context in these calls, and it would use those configurations.
Payment payment = new Payment();
// Fill in all the details.
payment.create(defaultContext);
// Replace that defaultContext with any of those other contexts.