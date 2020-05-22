VimService vimServiceRSC = new VimService();
VimPortType vimPortRSC = vimService.getVimPort();

Map<String, Object> ctxtRSC = ((BindingProvider)vimPortRSC).getRequestContext();
ctxtRSC.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url.toString());

ServiceContent serviceContent = vimPortRSC.retrieveServiceContent(this.getServiceInstanceRef());
vimPort.login(serviceContent.getSessionManager(), "user", "password", null);