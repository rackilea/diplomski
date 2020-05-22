@Test
    public void testAggProjection() { 
        DBCollection collection = template.getCollection("test-collection");

        DBObject ob = new BasicDBObject(ImmutableMap.of("test", "value1", "something", "here"));
        DBObject ob2 = new BasicDBObject(ImmutableMap.of("test", "value1", "hello", "world"));
        DBObject ob3 = new BasicDBObject(ImmutableMap.of("test", "value2", "other", "fields"));
        WriteResult insert = collection.insert(ob, ob2, ob3);
        Assert.assertEquals(3, insert.getN());

        DBObject match = new BasicDBObject("$match", new BasicDBObject("test", "value1")); // match the test value 
        Map<String, Object> grouping = new HashMap<>();
        grouping.put("_id", "$test");
        grouping.put("my_count", new BasicDBObject("$sum", 1));
        DBObject group = new BasicDBObject("$group", grouping); // group by 

        AggregationOutput aggregate = collection.aggregate(match, group);
        System.out.println(aggregate.results());
        DBObject next = aggregate.results().iterator().next();
        Assert.assertTrue(next.containsField("_id"));
        Assert.assertTrue(next.containsField("my_count"));


        // with documents raw 
        MongoClient mc = (MongoClient) client;
        MongoCollection<Document> collection2 = mc.getDatabase(template.getDb().getName()).getCollection("test-collection");

        Document dob = new Document(ImmutableMap.of("test", "value1", "something", "here"));
        Document dob2 = new Document(ImmutableMap.of("test", "value1", "hello", "world"));
        Document dob3 = new Document(ImmutableMap.of("test", "value2", "other", "fields"));

        collection2.insertMany(Arrays.asList(dob, dob2, dob3));

        long count = collection2.count();
        Assert.assertEquals(3, count);

        Document match2 = new Document("$match", new Document("test", "value1"));
        Document group2 = new Document("$group", ImmutableMap.of("_id", "$test", "my_count", new Document("$sum", 1)));

        AggregateIterable<Document> aggregate2 = collection2.aggregate(Arrays.asList(match2, group2));
        Document next2 = aggregate2.iterator().next();
        Assert.assertTrue(next2.get("_id") != null);
        Assert.assertTrue(next2.get("my_count") != null);
    }