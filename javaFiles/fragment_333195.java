RedisClient redisClient = RedisClient.create("redis://password@localhost:6379/0");
StatefulRedisConnection<String, String> connection = redisClient.connect();
RedisCommands<String, String> syncCommands = connection.sync();
syncCommands.multi();
syncCommands.sadd("topics", "value1", "value2", "value3"); // Puts topics in the set
syncCommands.set("posts", "serialized post"); // Puts serialized post
syncCommands.exec();