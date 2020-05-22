Function<String, BiFunction<String,String,String>> consume 
            = new Function<String, BiFunction<String,String,String>>() {
        @Override
        public BiFunction<String, String, String> apply(final String k) {
            return new BiFunction<String, String, String>() {

                @Override
                public String apply(String o, String n) {
                    System.out.println(k +"="+ o);
                    return o;
                }
            };
        }
    };
    LogManager.getLogManager().updateConfiguration(consume);