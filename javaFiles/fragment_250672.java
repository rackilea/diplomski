KStreamBuilder builder = new KStreamBuilder();
builder.stream("INPUT_TOPIC")
       .filter(new Predicate() {
           @Overwrite
           boolean test(String key, String value) {
               // put you processor logic here
               return message.get("UserID").equals("1")
           }
        })
       .to("OUTPUT_TOPIC");