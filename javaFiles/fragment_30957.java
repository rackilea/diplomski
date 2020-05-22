RethinkDB.r.db("squirrel")
    .table("knownurifilter")
    // Java 7 and earlier
    .filter(new ReqlFunction1() {
        @Override
        public Object apply(final ReqlExpr doc) {
            return doc.getField("timestampNextCrawl").le(System.currentTimeMillis());
        }
    })
    .getField("uri")
    .run(connector.connection)