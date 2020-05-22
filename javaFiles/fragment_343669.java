@Bean
RedisQueueMessageDrivenEndpoint redisQueueMessageDrivenEndpoint(RedisConnectionFactory redisConnectionFactory, RedisSerializer<?> serializer) {
    RedisQueueMessageDrivenEndpoint endpoint =
                new RedisQueueMessageDrivenEndpoint("archive.post.publication.queue", redisConnectionFactory);
    endpoint.setOutputChannelName("postPublicationChannel");
    endpoint.setErrorChannelName("postPublicationLoggingChannel");
    endpoint.setReceiveTimeout(5000);
    endpoint.setSerializer(serializer);
    return endpoint;
}