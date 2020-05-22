Config conf = new Config();
        conf.setDebug(true);
        conf.setNumWorkers(1);

        try(LocalDRPC drpc = new LocalDRPC())
        {
            LocalCluster cluster = new LocalCluster();
            var builder = BasicRedisRPCTopology.createBuilder(Optional.of(drpc));
            cluster.submitTopology("Sales-fetch", conf, builder.createTopology());
            var result = drpc.execute("sales", "XXXXX");
            System.out.println("################ Result: " + result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }