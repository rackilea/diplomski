public class Main {

    public static void main(String[] args) {
        System.out.println(new Parser("(( a + b ) + (( c + d )))").parse());
        System.out.println(new Parser("(( a + b ) * (( c + d )))").parse());
    }
}

public class Parser {
    private final static char EOF = ';';
    private String input;
    private int currPos;

    public Parser(String input) {
        this.input = input + EOF; // mark the end
        this.currPos = -1;
    }

    public String parse() throws IllegalArgumentException {
        nextToken();
        Result result = expression();
        if(currToken() != EOF) {
            throw new IllegalArgumentException("Found unexpected character '" + currToken() + "' at position " + currPos);
        }
        return result.getText();
    }

    // "expression()" handles "term" or "term + term" or "term - term"
    private Result expression() throws IllegalArgumentException {
        Result leftArg = term();

        char operator = currToken();
        if (operator != '+' && operator != '-') {
            return leftArg; // EXIT
        }
        nextToken();

        Result rightArg = term();

        if(operator == '-' && (rightArg.getOp() == '-' || rightArg.getOp() == '+')) {
            rightArg = encloseInParentheses(rightArg);
        }

        return new Result(leftArg.getText() + " " + operator + " " + rightArg.getText(), operator);
    }

    // "term()" handles "factor" or "factor * factor" or "factor / factor"
    private Result term() throws IllegalArgumentException {
        Result leftArg = factor();

        char operator = currToken();
        if (operator != '*' && operator != '/') {
            return leftArg; // EXIT
        }
        nextToken();

        Result rightArg = factor();

        if(leftArg.getOp() == '+' || leftArg.getOp() == '-') {
            leftArg = encloseInParentheses(leftArg);
        }
        if(rightArg.getOp() == '+' || rightArg.getOp() == '-' || (operator == '/' && (rightArg.getOp() == '/' || rightArg.getOp() == '*'))) {
            rightArg = encloseInParentheses(rightArg);
        }

        return new Result(leftArg.getText() + " " + operator + " " + rightArg.getText(), operator);
    }

    // "factor()" handles a "paren" or a "variable"
    private Result factor() throws IllegalArgumentException {
        Result result;
        if(currToken() == '(') {
            result = paren();
        } else if(Character.isLetter(currToken())) {
            result = variable();
        } else {
            throw new IllegalArgumentException("Expected variable or '(', found '" + currToken() + "' at position " + currPos);
        }
        return result;
    }

    // "paren()" handles an "expression" enclosed in parentheses
    // Called with currToken an opening parenthesis
    private Result paren() throws IllegalArgumentException {
        nextToken();
        Result result = expression();
        if(currToken() != ')') {
            throw new IllegalArgumentException("Expected ')', found '" + currToken() + "' at position " + currPos);
        }
        nextToken();
        return result;
    }

    // "variable()" handles a variable
    // Called with currToken a variable
    private Result variable() throws IllegalArgumentException {
        Result result = new Result(Character.toString(currToken()), ' ');
        nextToken();
        return result;
    }

    private char currToken() {
        return input.charAt(currPos);
    }

    private void nextToken() {
        if(currPos >= input.length() - 1) {
            throw new IllegalArgumentException("Unexpected end of input");
        }
        do {
            ++currPos;
        }
        while(currToken() != EOF && currToken() == ' ');
    }

    private static Result encloseInParentheses(Result result) {
        return new Result("(" + result.getText() + ")", result.getOp());
    }

    private static class Result {
        private final String text;
        private final char op;

        private Result(String text, char op) {
            this.text = text;
            this.op = op;
        }

        public String getText() {
            return text;
        }

        public char getOp() {
            return op;
        }
    }
}