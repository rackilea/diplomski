final TopDocs merge = TopDocs.merge(1000, new TopDocs[]{topDocs1, topDocs2});
        Set<ScoreDoc> scoreDocs = new TreeSet<>(new Comparator<ScoreDoc>() {
            @Override
            public int compare(ScoreDoc o1, ScoreDoc o2) {
                return Integer.compare(o1.doc, o2.doc);
            }
        });
        float maxScore = Float.MIN_VALUE;
        for (int i = 0; i < merge.scoreDocs.length; ++i) {
            final ScoreDoc[] scoreDocs1 = merge.scoreDocs;
            scoreDocs.add(scoreDocs1[i]);
            if (scoreDocs1[i].score > maxScore) {
                maxScore = scoreDocs1[i].score;
            }
        }
        final TopDocs filteredTopDocs = new TopDocs(scoreDocs.size(), scoreDocs.toArray(new ScoreDoc[0]), maxScore);