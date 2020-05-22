for (String field: fields){
    Query query = new WildcardQuery(new Term(field, "*alue1"));
    Explanation ex = searcher.explain(query, docID);
    if (ex.isMatch()){
        //Your query matched field
    }
}