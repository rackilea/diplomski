public PCollection<Put> createPut(final PTable<String, String> counts) {
   return counts.parallelDo("Convert to puts", new DoFn<Pair<String, String>, Put>() {
     @Override
     public void process(final Pair<String, String> input, final Emitter<Put> emitter) {
       Put put;
       // input.first is used as row key
       put = new Put(Bytes.toBytes(input.first())); 
       // the value (input.second) is added with its family and qualifier
       put.add(COLUMN_FAMILY_TARGET, COLUMN_QUALIFIER_TARGET_TEXT, Bytes.toBytes(input.second())); 
       emitter.emit(put);
     }
   }, Writables.writables(Put.class));
 }