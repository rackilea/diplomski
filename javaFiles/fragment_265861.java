use Inline Java => <<END ;
import java.util.* ;
import org.perl.inline.java.* ;

class Pod_regexp extends InlineJavaPerlCaller {
    public Pod_regexp() throws InlineJavaException {
    }

    public boolean match(String target, String pattern)
        throws InlineJavaException {
        try {
            String m = (String)CallPerlSub("main::regexp",
            new Object [] {target, pattern}) ;

            if (m.equals("1")){
            return true ;
        }
    }
    catch (InlineJavaPerlException pe){
        // $@ is in pe.GetObject()
    }

    return false ;
    }
}
END

my $re = new Pod_regexp() ;
my $match = $re->match("Inline::Java", "^Inline") ;
print($match . "n") ; # prints 1

sub regexp {
    my $target = shift ;
    my $pattern = shift ;

    return ($target =~ /$pattern/) ;
}