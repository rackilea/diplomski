import java.util.*;

public class MyTinyParser {

    private static final String COMMANDS = "AND OR FOO BAR";

    private List<String> extract( String input ) {

        List<String> parts = new ArrayList<String>();

        // removing comments
        input = input.split( ";" )[0];

        // splits using spaces
        String[] firstPass = input.trim().split( " " );

        for ( String s : firstPass ) {

            // the current part cannot be empty
            if ( !s.trim().isEmpty() ) {

                // splits using comma
                String[] secondPass = s.split( "," );

                for ( String ss : secondPass ) {
                    parts.add( ss.replace( ",", "" ) );
                }

                // verifies if the current part has a comma
                // and if so, inserts it as a part
                if ( s.contains( "," ) ) {
                    parts.add( "," );
                }

            }

        }

        return parts;

    }

    public List<Token> tokenize( String input ) {

        List<Token> tokens = new ArrayList<Token>();

        for ( String str : extract( input ) ) {

            Token token = new Token( str );

            // check if int
            try{
                Integer.parseInt( str );
                token.type = "number";
            } catch(NumberFormatException e) {
            }

            if ( token.type == null ) {

                if ( COMMANDS.contains(str)){
                    token.type = "command";
                } else if (str.contains(",")) {
                    token.type = "delimiter";
                } else {
                    token.type = "unknown";
                }

            }

            if( !token.type.equals( "unknown" ) ) {
                tokens.add( token );
            }

        }

        return tokens;

    }

    private class Token {

        String value;
        String type;

        Token( String value ) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format( "Token[%s, %s]", value, type );
        }

    }

    public static void main( String[] args ) {

        MyTinyParser mtp = new MyTinyParser();
        List<Token> tokens = mtp.tokenize( "AND 3,    4, 5   ; some comments" );

        for ( Token t : tokens ) {
            System.out.println( t );
        }

    }

}