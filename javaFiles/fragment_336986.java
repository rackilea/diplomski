StreamExecutionEnvironment environment =
            StreamExecutionEnvironment.getExecutionEnvironment();

    DataStream<Long> someIntegers = environment.generateSequence(0, 0);
    someIntegers.map(aLong -> aLong + 1).print();
    someIntegers.map(aLong -> aLong + 2).print();

    environment.execute();