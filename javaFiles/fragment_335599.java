public class RestClient {
    public User getUser(String userName) throws UniformInterfaceException {
        final WebResource.Builder userResource = webResource
           .path(String.format("/user/%s", userName))
           .accept(MediaType.APPLICATION_XML) ;
        return userResource.get(User.class);
    }

    public Collection<Tweet> getTweets(String userName)
        throws UniformInterfaceException {
        final WebResource.Builder tweetResource = webResource
           .path(String.format("/user/%s/tweets", userName))
           .accept(MediaType.APPLICATION_XML);
        return tweetResource.get(new GenericType<Collection<Tweet>>(){});
    }
}