try{
        cluster.submitTopology("Test", config, builder.createTopology());
        //Sleep here
    }finally{
        cluster.shutdown();
    }