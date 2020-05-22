public class TParser extends Parser {

    // $ANTLR start "parse"
    // T.g:3:1: parse : ( foo | bar | OTHER );
    public final void parse() throws RecognitionException {
        ...
    }
    // $ANTLR end "parse"

    // $ANTLR start "foo"
    // T.g:9:1: foo : INT ;
    public final void foo() throws RecognitionException {
        ...
    }
    // $ANTLR end "foo"


    // $ANTLR start "bar"
    // T.g:10:1: bar : ALPHA ;
    public final void bar() throws RecognitionException {
        ...
    }
    // $ANTLR end "bar"
}