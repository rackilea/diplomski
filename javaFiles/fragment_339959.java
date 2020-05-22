PCollection<ChatHistory> json_objects = lines.apply(ParDo.of(new ExtractObjectsFn()));

  // Create a row type first:
  List<String> fields_list= new ArrayList<String>(Arrays.asList("conversation_id","message_type","message_date","message","message_auto_id"));
  List<Integer> types_list= new ArrayList<Integer>(Arrays.asList(Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR));
  final BeamRecordSqlType brtype = BeamRecordSqlType.create(fields_list, types_list);

  // Convert them to BeamRecords with the same schema as defined above via a DoFn.
  PCollection<BeamRecord> apps = json_objects.apply(
      ParDo.of(new DoFn<ChatHistory, BeamRecord>() {
        @ProcessElement
        public void processElement(ProcessContext c) {
            BeamRecord br = new BeamRecord(
                          brtype, 
                          c.element().conversation_id, 
                          c.element().message_type, 
                          c.element().message_date,
                          c.element().message, 
                          c.element().message_auto_id
                          );
            c.output(br);
        }
      })); 

  return apps
    .setCoder(brtype.getRecordCoder())
    .apply(
      BeamSql
          .query("SELECT conversation_id, message_type, message, message_date, message_auto_id FROM PCOLLECTION")
   );