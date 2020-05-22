@Override
public void addConnectionFactories( ConnectionFactoryConfigurer cfConfig)
{
    TwitterConnectionFactory twitterConnectionFactory = new TwitterConnectionFactory( "twitter.appId", "twitter.appSecret" );
    cfConfig.addConnectionFactory( twitterConnectionFactory );
}