class WindowsStoreCertificateCredentials(clientId: String, certificate: X509Certificate, privateKey: PrivateKey) extends KeyVaultCredentials {

def getAuthResult(authority: String, resource: String): AuthenticationResult  = {       
  val service  = Executors.newFixedThreadPool(1)
  val context = new AuthenticationContext(authority, false, service)

  val certificateCredentials = AsymmetricKeyCredential.create(clientId, privateKey, certificate)
  val authResultFuture = context.acquireToken(resource, certificateCredentials, null)
  authResultFuture.get
}

override def doAuthenticate (authority: String, resource: String, scope: String): String = {
  getAuthResult(authority, resource).getAccessToken
}