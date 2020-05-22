import static com.mongodb.client.model.Filters.*;

    List<Document> docs = new ArrayList<>();
        collection.find(
                gte("publishedDateTime", 
                        LocalDate.of(2019, 02, 25)))
        .into(docs);