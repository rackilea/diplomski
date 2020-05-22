RedissonClient redisson = Redisson.create(config);

RLock lock = redisson.getLock("myLock");
lock.lock();
try {
   // ...
} finally {
   lock.unlock();
}