// Create general records DB
Map<String, Map<Date, Record>> records = new HashMap<>();

// Create sub DB for records with same ID
Map<Date, Record> subRecords = new HashMap<>();

// Assuming you've got from somewhere id, title and rest of the parameters
subRecords.put(recordDate, new Record(id, title, time, duration));
records.put(recordId, subRecords)

// Now checking and updating records as simple as
sub = records.get(someTitle); // Assuming you've got someTitle
if (sub != null) {
   record = sub.get(someDate); // Same for someDate
   if (record != null) {
       record.updateTime(newTime);
   }
}