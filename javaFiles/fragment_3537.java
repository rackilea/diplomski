Long zCard = template.execute(new RedisCallback<Long>() {

  @Override
  public Long doInRedis(RedisConnection connection) throws DataAccessException {
    return connection.zCard(potentiallyExtractBytes(key));
  }

  private byte[] potentiallyExtractBytes(Object key) {
    return (key instanceof byte[]) ? (byte[]) key : key.toString().getBytes();
  }

});