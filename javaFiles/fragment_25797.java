SearchHit[] results = response.getHits().getHits();
    for (SearchHit hit : results) {
        String sourceAsString = hit.getSourceAsString();
        Map<String, SearchHitField> responseFields = hit.getFields();
        SearchHitField field = responseFields.get("product_id");
        Map map = hit.getSource();
        System.out.println(map.toString());
    }