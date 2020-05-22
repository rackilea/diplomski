public static enum UserChoice {
    /*
     * Establish the mapping between the enum value (the semantic action)
     * and the user's input.  This can be adapted to whatever form the user
     * input takes and is decoupled from the ordinal values.  It's all in 
     * one place here and a change here does not need a change anywhere else.
     */
    QUIT            ( 0), 
    LIST_BOOKS      ( 1), 
    CHECKOUT_BOOK   ( 2), 
    RETURN_BOOK     ( 3), 
    LIST_MOVIES     ( 4),
    CHECKOUT_MOVIE  ( 5), 
    RETURN_MOVIE    ( 6), 
    USER_INFORMATION( 7),
    INVALID_CHOICE  (Integer.MIN_VALUE);

    /*
     * The mapping, and its initialization, using the new features in Java 8
     */
    private static final Map<Integer,UserChoice> valueMap = Arrays.stream(UserChoice.values()).collect(Collectors.toMap(UserChoice::getValue, Function.identity()));

    /*
     * A method to convert from user input (int in this case) to the corresponding
     * enum value based on the mapping above.
     */
    public static UserChoice fromUserInput(int input) {
        return Optional.ofNullable(valueMap.get(input)).orElse(INVALID_CHOICE);
    }

    /*
     * Per-enum value and method
     */
    private final int userValue;
    private UserChoice(int userValue) { this.userValue = userValue; }
    public int getValue() { return this.userValue; }
}

/*
 * Simple test
 */
public static void main(String args[]) throws Exception 
{
    for (int i=0; i<10; i++)
    {
        UserChoice c = UserChoice.fromUserInput(i);
        System.out.printf("Input %d enum is %s\n", i, c.toString());
    }
}