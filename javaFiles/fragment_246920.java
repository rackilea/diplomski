public abstract class CriteriaBuilderHelper {

    private static final String PG_STRING_AGG  = "string_agg";

    /**
    * @param cb the CriteriaBuilder to use
    * @param toJoin the string to join
    * @param delimiter the string to use
    * @return Expression<String>
    */
    public static Expression functionStringAgg(CriteriaBuilder cb, String toJoin, String delimiter) {
        return cb.function(PG_STRING_AGG, 
            String.class,
            cb.literal(toJoin),
            cb.literal(delimiter))
        );
    }
}