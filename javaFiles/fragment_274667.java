stream
   .transform(() -> new Transformer<Integer, Integer, KeyValue<Integer, Integer>>() {
       private ProcessorContext context;

       @Override
       public void init(final ProcessorContext context) {
           this.context = context;
       }

       @Override
       public KeyValue<Integer, Integer> transform(final Integer key, final Integer value) {
           context.forward(key, value);
           context.forward(key + 1, value + 1;)
           return null;
       }

       @Override
       public void close() {
       }
   }, stateStoreName);