public void start(JedisPool jedispool, Jedis publisherJedis, String channel,String data, String redisPassword)
{
    if(!redisPassword.equals(""))
        publisherJedis.auth(redisPassword);
    publisherJedis.publish(channel,data);
    log.debug("Jsondata is added into the queue " +data);
    try{
        publisherJedis.close();
        log.debug(" Is Jedis connected " +publisherJedis.isConnected());
        if(publisherJedis.isConnected())
            publisherJedis.disconnect();
        log.debug(" After disconnecting: is redis connected  " +publisherJedis.isConnected());
    }catch(Exception e){
        log.debug("Error occured " +e);
    }
}