JsonElement authorsJson  = new JsonParser().parse(json).getAsJsonObject().get("authors");

Type authorList = new TypeToken<List<Author>>(){}.getType();
List<Author> authors = gson.fromJson(authorsJson, authorList);
for(Author a : authors) {
    System.out.println(a.name);
    for(Book b : a.books) {
        System.out.println("\t " + b.title + " by " + b.author.name);
    }
}