@Override
public void addConnectionFactories( ConnectionFactoryConfigurer cfConfig )
{    
    System.setProperty( "http.proxyPort", "8090" );
    System.setProperty( "https.proxyPort", "8090" );
    System.setProperty( "http.proxyHost", "192.168.1.50" );
    System.setProperty( "https.proxyHost", "192.168.1.50" );
    TwitterConnectionFactory twitterConnectionFactory = new TwitterConnectionFactory( "twitter.appId", "twitter.appSecret" );
    cfConfig.addConnectionFactory( twitterConnectionFactory );
}