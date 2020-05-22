@Autowired
        private AtomicReference<BulkRequest> bulkRequest;

        @PostMapping
        public void index(@RequestBody String o) {
            synchronized (bulkRequest.get()) {
                bulkRequest.get().add(new IndexRequest(config.INDEX, config.TYPE).source(o, XContentType.JSON));
            }
        }

        @DeleteMapping(path="/{id}")
        public void delete(@PathVariable String id) {
            synchronized (bulkRequest.get()) {
                bulkRequest.get().add(new DeleteRequest(config.INDEX, config.TYPE, id));
            }
        }

        @PutMapping(path="/{id}")
        public void update(@PathVariable String id, @RequestBody String o) {
            synchronized (bulkRequest.get()) {
                bulkRequest.get().add(new UpdateRequest(config.INDEX, config.TYPE, id).doc(o, XContentType.JSON));
            }
        }

 @PostMapping(path = "/flush")
    public String flush() throws Exception {
        synchronized (bulkRequest.get()) {
            String result = bulkService.flush(bulkRequest);

            bulkRequest.set(new BulkRequest());

            return result;
        }
    }