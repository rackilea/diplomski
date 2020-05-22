Document query = new Document("$and", Arrays.asList(new Document(
            doc.getIdName(), new BsonString(doc.getIdValue())),
            new Document("doc_version", new Document("$lt",
                doc.getVersion()))));
        writes.add(new ReplaceOneModel<Document>(query, doc.getDoc(),
            updateOptions));