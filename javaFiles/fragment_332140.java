final SetExpressCheckoutRequestType ppRequest = ...; // here you create your request as in code snippet above

final Properties serviceConfigurationProperties = ...; // bookmark #1
final PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(serviceConfigurationProperties);

final SetExpressCheckoutReq request = new SetExpressCheckoutReq();
request.setSetExpressCheckoutRequest(ppRequest);

final ICredentials credentials = new SignatureCredentials(username, password, signature);
final SetExpressCheckoutResponseType response = service.setExpressCheckout(request, credentials);