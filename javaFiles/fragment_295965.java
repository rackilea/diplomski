List<Bson> filters = new ArrayList<>();
for (Map.Entry<String, Object> entry : query.getParams().entrySet()) {
        // this is where its building the query
   if (some condition){
       filters.add(Filters.eq(entry.getKey(), entry.getValue()));
   }
   if (some other condition){
       filters.add(Filters.in(entry.getKey(), query.getValues()));
   }
}
FindIterable<TDocType> docType = dbCollection.find(Filters.and(filters));