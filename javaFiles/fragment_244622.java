Observable<Boolean> obs = Observable.zip(
    client.getCategories(),
    client.getPosts(), 
    (categoriesList, postsList) -> {
         // you have here both categories and lists
         // write any code you like, for example inserting to db
         return true;
});