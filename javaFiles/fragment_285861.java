public class Criteria implements CriteriaDefinition {

    /**
     * Custom "not-null" object as we have to be able to work with {@literal null} values as well.
     */
    private static final Object NOT_SET = new Object();

    private String key;
    private List<Criteria> criteriaChain;  \\This datamember is used when you are using and