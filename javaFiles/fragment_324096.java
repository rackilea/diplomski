ProducerTemplate tmp = ctx.createProducerTemplate();

        tmp.setDefaultEndpoint(ctx.getEndpoint(uri+"&partitioner={{partitioner.class}}"));
        ctx.start();
        tmp.sendBodyAndHeader("my test is working "+(new Random()).nextInt(100), KafkaConstants.PARTITION_KEY, 1);
        tmp.stop();
        ctx.stop();