// Create object mapper
ObjectMapper objectMapper = new ObjectMapper();

// Set serialisation/deserialisation options if needed (property naming strategy, etc...)

Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://yourapi")
        .addConverterFactory(new JSONAPIConverterFactory(objectMapper, Book.class, Author.class))
        .build();

// Create service using service interface
MyBooksService booksService = retrofit.create(MyBooksService.class);