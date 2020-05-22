public void search() throws IOException {
        System.out
                .println("\nLatLonQuery around given point, 10km radius --------------------------------------");
        Query distQuery = LatLonPoint.newDistanceQuery("latlon", -6.08165, 145.8612430, dist * 1000);
        long startTime=0;//adjust according to your needs
        long endTime=Long.Max_VALUE;//adjust according to your needs
        Query timeQuery = LongPoint.newRangeQuery("timestamp", startTime, endTime);

        BooleanQuery booleanQuery = new BooleanQuery.Builder()
            .add(distQuery, Occur.MUST)
            .add(timeQuery, Occur.MUST)
            .build();
        TopDocs docs = searcher.search(booleanQuery, 20);
        for (ScoreDoc scoreDoc : docs.scoreDocs) {
            Document doc = searcher.doc(scoreDoc.doc);
            System.out.println(doc);
        }
    }