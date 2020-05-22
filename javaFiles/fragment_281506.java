@Override
public void configure(final HttpsParameters params)
{
   try
   {
      final SSLParameters sslParams = getSSLContext().getDefaultSSLParameters();
      final SSLEngine sslEngine = getSSLContext().createSSLEngine();
      sslParams.setNeedClientAuth( true );
      sslParams.setCipherSuites( sslEngine.getEnabledCipherSuites() );
      sslParams.setProtocols( sslEngine.getEnabledProtocols() );
      params.setSSLParameters( sslParams );
   }
   catch ( final Exception e )
   {
      LOG.error( ExceptionUtils.getStackTrace( e ) );
   }
}