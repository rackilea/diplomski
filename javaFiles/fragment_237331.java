public static TopologyBuilder createBuilder(Optional<ILocalDRPC> localDRPC)
    {
        var spout = localDRPC
                .map(drpc -> new DRPCSpout("sales", drpc))
                .orElse(new DRPCSpout("sales"));
        var bolt = new RedisSalesLookupBolt(createRedisConfiguration(), new RedisTurnoverMapper());
        var builder = new TopologyBuilder();
        builder.setSpout("drpc", spout);
        builder.setBolt("redisLookup", bolt, 1)
               .shuffleGrouping("drpc");
        builder.setBolt("return", new ReturnResults())
               .shuffleGrouping("redisLookup");
        return builder;
    }