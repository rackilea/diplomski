public static enum TokenType{



    ADDSUB("[+|-]?"),NUMBER("-?[0-9]+"),
    INCDEC("[[++]|[--]]"),DIVMOD("[/|%]"),
    ID("[_a-zA-Z][_a-zA-Z0-9]*"),
    MUL("[*]+"), WHITESPACE("[ \t\f\r\n]+");


    public final String pattern;

    private TokenType(String pattern){
        this.pattern=pattern;
    }
}