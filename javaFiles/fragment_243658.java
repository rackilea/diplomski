@Grab('org.spockframework:spock-core:0.7-groovy-2.0')
@Grab('cglib:cglib-nodep:3.1')

import spock.lang.*

class CallingClassTest extends Specification {

    def "check that functionTwo calls functionOne"() {
        def c = Spy(CallingClass)

        when:
        def s = c.functionTwo()

        then:
        1 * c.functionOne() >> "mocked function return"
        s == "some string mocked function return"
    }
}

public class CallingClass {

    public String functionOne() {
        "one"
    }

    public String functionTwo() {
        String one = functionOne()        
        "some string $one"
    }
}