public class TLexer extends Lexer {

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        // T.g:12:7: ( ( '0' .. '9' )+ )
        ...
    }
    // $ANTLR end "INT"

    // $ANTLR start "ALPHA"
    public final void mALPHA() throws RecognitionException {
        // T.g:13:7: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
        ...
    }
    // $ANTLR end "ALPHA"

    // $ANTLR start "OTHER"
    public final void mOTHER() throws RecognitionException {
        // T.g:14:7: ( . )
        ...
    }
    // $ANTLR end "OTHER"
}