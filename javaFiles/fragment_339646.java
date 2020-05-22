VimService vimService = new VimService();
VimPortType vimPort = vimService.getVimPort();

Map<String, Object> ctxt = ((BindingProvider)vimPort).getRequestContext();
ctxt.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url.toString());
ctxt.put(org.apache.axis2.Constants.CUSTOM_COOKIE_ID, "vmware_soap_session");
ctxt.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);