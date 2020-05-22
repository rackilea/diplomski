public String handleRequest(KinesisFirehoseEvent event, Context context)
    List<KinesisFirehoseEvent.Record> records = event.getRecords();
    for(KinesisFirehoseEvent.Record rec : records)
    {
        String recordId = rec.getRecordId();
        String data = StandardCharsets.UTF_8.decode(rec.getData()).toString();

        Item item = transformStringToItem(data);
        // Write the item to the table 
        table.putItem(item);
    }
    return "success";
}