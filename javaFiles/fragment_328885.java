@SuppressWarnings("unchecked")
 public static <T> List<T> readJsonList(String listName) {
 . . .
 while (reader.hasNext()) {
     reader.next();
     if ("races".equals(listName) && "races".equals(reader.name())) {
         result = result = (List<T>) processRaceData(reader);
         break;
     }
     if ("npc".equals(listName) && "npc".equals(reader.name())) {
         result = result = (List<T>) processNpcData(reader);
         break;
     }
     reader = reader.skipValue();
 }
 reader.endObject();
 . . .