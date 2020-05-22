class MyNameRepository {
    MongoOperations mongoOperations; // injected

    public Collection<Name> findByName(String like) {
        try{
            Query query = new Query();
            query.addCriteria(Criteria.where("name").regex(toLikeRegex(like)));
            return mongoOperations.find(query, Name.class);
        } catch(PatternSyntaxException e) {
            return Collections.emptyList();
        }
    }

    private String toLikeRegex(String source) {
        return source.replaceAll("\\*", ".*");
    }
}