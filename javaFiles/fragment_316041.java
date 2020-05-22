class MissingRightParenException extends CalculationException {
    ...
}

class CalculationException extends Exception {
    ...
}

class MyClass {

    int myMathRelatedMethod(String calculation) throws CalculationException {
        ...
        if (somethingWrong) {
            throw new MissingRightParenException("Missing right paren for left paren at location: " + location);
        }
        ...
    }

    public static void main(String ... args) {        
        ...
        try {
            myMathRelatedMethod(args[0]);
        } catch (CalculationException e) {
            // stack trace not needed maybe
            System.err.println(e.getMessage());
        }
        ...
    }
}