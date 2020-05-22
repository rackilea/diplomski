// The JSON
final String json = "{\"authors\":{\"author\":[{\"given-name\":\"AdrienneH.\",\"surname\":\"Kovacs\"},{\"given-name\":\"Philip\",\"surname\":\"Moons\"}]}}";

ObjectMapper mapper = new ObjectMapper();

// Read the response as a tree model
final JsonNode response = mapper.readTree(json).path("authors").path("author");

// Create the collection type (since it is a collection of Authors)
final CollectionType collectionType =
        TypeFactory
                .defaultInstance()
                .constructCollectionType(List.class, Author.class);

// Convert the tree model to the collection (of Author-objects)
List<Author> authors = mapper.reader(collectionType).readValue(response);

// Now the authors-list is ready to use...