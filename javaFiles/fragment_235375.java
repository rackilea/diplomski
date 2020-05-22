//from https://github.com/abelaska/jedis-lock
Jedis jedis = new Jedis("localhost");
JedisLock lock = new JedisLock(jedis, "lockname", 10000, 30000);
lock.acquire();
try {
  // do some stuff
}
finally {
  lock.release();
}