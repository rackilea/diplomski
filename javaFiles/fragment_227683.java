@Bean
public RedisCustomConversions redisCustomConversions(RedisReadingByteConverter readingConverter,
                                                     RedisWritingByteConverter redisWritingConverter,
                                                     RedisWritingStringConverter redisWritingByteConverter,
                                                     RedisReadingStringConverter redisReadingByteConverter) {
    return new RedisCustomConversions(Arrays.asList(readingConverter, redisWritingConverter, redisWritingByteConverter, redisReadingByteConverter));
}