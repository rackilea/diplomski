val ws = (new MyJAXWSWebService()).getMyJAXWSWebServiceSoap
val context = ws.asInstanceOf[BindingProvider].getRequestContext

// their certificate doesn't match domain!
context.put(JAXWSProperties.HOSTNAME_VERIFIER, new HostnameVerifier() {
  def verify(s: String, sslSession: SSLSession) = true
})