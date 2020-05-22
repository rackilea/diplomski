try (Jedis jedis = new Jedis(host, port)) {
  Pipeline pipeline = jedis.pipelined();
  while (iter.hasNext()) {
    String[] keyValue = iter.next().split("\t");
    pipeline.sadd(keyValue[0], keyValue[1]);
    // you can call pipeline.sync() and start new pipeline here if you think there're so much operations in one pipeline
  }
  pipeline.sync();
}