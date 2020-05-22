Map resultMap = new HashMap();
while ((csvLine = reader.readLine()) != null) {
   String[] row = csvLine.split(";");
   String id = row[0];
   Integer score = Integer.parseInt(row[1]);
   resultMap.put(id, score);
}