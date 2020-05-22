Document filter = new Document("base-doc-field","<value>");//query for base doc 
   //fields if any

Document updateDoc = new Document("$inc",
     new Document("listOfItems.$[elem].setOfItems.$[elem1].fieldName","value to  
        update"));


 //prepare array filters.
  List<Bson> arrayFilters = new ArrayList<>();
  arrayFilters.add(new Document("elem.listId","<list_id>"));
  arrayFilters.add(new Document("elem1.itemId","<item_id>"));

 //prepare update options, and set these array filters to update options.
 UpdateOptions options = new UpdateOptions().
                  arrayFilters(filterArr).bypassDocumentValidation(true);

 //execute update method.
 collection.updateOne(filter,updateDoc,options);