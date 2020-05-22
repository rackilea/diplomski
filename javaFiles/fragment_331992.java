class Dog {
  long id;
  @JsonAdapter(DateTypeAdapter.class)
  Date purchaseDate; //Convert milliseconds to date
  String name;
  int status; //If boolean is false then 0 else 1
}