public List<ArticleData> doAdvancedSearch(String searchString) {
        List<ArticleData> list = new ArrayList<>();

        DBCursor cursor = collection.find(new BasicDBObject("$text", new BasicDBObject("$search", searchString)));
        while (cursor.hasNext()) {
            DBObject document = cursor.next();
            ArticleData data = new ArticleData();
            data.setContent((String) document.get("content"));
            data.setTitle((String) document.get("title"));
            list.add(data);
        }

        return list;
    }