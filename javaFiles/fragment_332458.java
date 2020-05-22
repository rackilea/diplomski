public String getLemma(String word) {
    criteria.set(0, word);
    DBObject lemmaObj = QueryBuilder.start("declensions").in(criteria).get();
    DBCursor cursor = declColl.find(lemmaObj);
    if(cursor == null)      return null;
    if(cursor.size() > 1)   return null;
    if(cursor.size() == 0)  return null;
    return (String) cursor.next().get("lemma");
}