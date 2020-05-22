Document query = new Document();
List<String> list1 = new ArrayList<String>();
List<Document> andQueryList = new ArrayList<Document>();
list1.add("90:200");
list1.add("350:400");
list1.add("560:700");

for (String time : list1) {
    String[] updatedAtt = time.split(":");

    andQueryList.add(new Document("$and", Arrays.asList(new Document("updated_at", new Document("$gte", Long.parseLong(updatedAtt[0]))),
                new Document("updated_at", new Document("$lte", Long.parseLong(updatedAtt[1]))))));
}
query.put("$or", andQueryList);