public class MyPredicate implements Predicate {
    private String testId;  
    private String otherId;

    public MyPredicate(String testId,String otherId) {
        this.testId = testId;
        this.otherId = otherId;
    }

    public boolean evaluate( Object obj ) {
        boolean match = false;
        if( obj instanceof MyObject ) {
            if( testId.equalsIgnoreCase( ((MyObject)obj).getId())
            && otherId.equalsIgnoreCase( ((MyObject)obj).getOtherId()) ) {
                match = true;
            }
        }
        return match;
    }
}