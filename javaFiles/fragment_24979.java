public class Main { 
    public static void main(String[] args) {
        String line = "foo,bar,c;qual=\"baz,blurb\",d;junk=\"quux,syzygy\"";

        String otherThanQuote = " [^\"] ";
        String quotedString = String.format(" \" %s* \" ", otherThanQuote);
        String regex = String.format("(?x) "+ // enable comments, ignore white spaces
                ",                         "+ // match a comma
                "(?=                       "+ // start positive look ahead
                "  (?:                     "+ //   start non-capturing group 1
                "    %s*                   "+ //     match 'otherThanQuote' zero or more times
                "    %s                    "+ //     match 'quotedString'
                "  )*                      "+ //   end group 1 and repeat it zero or more times
                "  %s*                     "+ //   match 'otherThanQuote'
                "  $                       "+ // match the end of the string
                ")                         ", // stop positive look ahead
                otherThanQuote, quotedString, otherThanQuote);

        String[] tokens = line.split(regex, -1);
        for(String t : tokens) {
            System.out.println("> "+t);
        }
    }
}