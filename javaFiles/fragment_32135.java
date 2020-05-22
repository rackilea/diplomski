ReadOnlyKeyValueStore<Object, String> store;

 input.process(() -> new Processor<Object, Product>() {

                @Override
                public void init(ProcessorContext processorContext) {
                    store = (ReadOnlyKeyValueStore) processorContext.getStateStore("my-store");


                }

                @Override
                public void process(Object key, Object value) {
                    //find the key
                    store.get(key);
                }

                @Override
                public void close() {
                    if (state != null) {
                        state.close();
                    }
                }
            }, "my-store");