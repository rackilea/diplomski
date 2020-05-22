VideoDynamoMappingAdapter videosToFind = new VideoDynamoMappingAdapter();
        videosToFind.setVideoCategory("Other");

        DynamoDBQueryExpression<VideoDynamoMappingAdapter> queryExpression = new DynamoDBQueryExpression<VideoDynamoMappingAdapter>()
                .withIndexName("CategoryIndex")
                .withHashKeyValues(videosToFind)
                .withConsistentRead(false);

        List<VideoDynamoMappingAdapter> itemList = mapper.query(VideoDynamoMappingAdapter.class, queryExpression);
        System.out.println("test" + itemList.size());