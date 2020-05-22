Query query = Query.query(Criteria.where("_id").is("some_id"));
Update update = Update.update("_id", "some_id")
                .set("field1", "value1")
                .set("field2", "value2")
                .set("subdocument2", subdocumentObject2)
                .setOnInsert("subdocument1", subdocumentObject1);