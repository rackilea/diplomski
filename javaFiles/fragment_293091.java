import org.codehaus.jparsec.Parser;
import org.codehaus.jparsec.Terminals;
import org.codehaus.jparsec.Tokens.Fragment;
import org.codehaus.jparsec.functors.Map;

public class Test
{
    static final Parser NUMBER = Terminals.DecimalLiteral.TOKENIZER.map(
            new Map<Fragment, Double>() {
                public Double map(Fragment arg0) {
                    return Double.valueOf(arg0.text());
                }
            });

    public static void main(String[] args)
    {
        System.out.println(NUMBER.parse("234234234"));
    }
}