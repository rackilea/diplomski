DataStream<String> wordDataStream = dataStream.flatMap(
    (String sentence, Collector<String> out) -> {
        for(String word: sentence.split(" "))
        out.collect(word); // collect objects of type String
    }
).returns(Types.STRING); // declare return type of flatmap lambda function as String