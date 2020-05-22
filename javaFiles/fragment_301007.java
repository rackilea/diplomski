DataStream<Tuple4<Integer, Integer, Integer, Integer,>> streamTuple = myConsumer.map(new MapFunction<String, Tuple4<Integer, Integer, Integer, Integer>>() {
            @Override
            public Tuple4<Integer, Integer, Integer, Integer> map(String str) throws Exception {
                String[] temp = str.split(",");
                return new Tuple4<>(
                        Integer.parseInt(temp[0]),
                        Integer.parseInt(temp[1]),
                        Integer.parseInt(temp[2]),
                        Integer.parseInt(temp[3])
                );

            }
        });