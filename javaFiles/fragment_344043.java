String categoriesForItem = getCategories(); // get "category1, category2, cat3" from a DB call

String [] categoriesForItems = categoriesForItem.split(","); 
for(String cat : categoriesForItems) {
    doc.add(new StringField("categories", cat , Field.Store.YES)); // doc is a Document 
}