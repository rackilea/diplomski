@Grab('org.spockframework:spock-core:0.7-groovy-2.0')
@Grab('cglib:cglib-nodep:3.1')

import spock.lang.*


class Test extends Specification {
    def "stub method returning long"() {
        given:
        Clock clock = Mock(Clock)

        when:
        Long currentTime = clock.currentTimeMillis()

        then:
        currentTime == 1
        1 * clock.currentTimeMillis() >> 1
    }

    def "mock method returning longs"() {
        given:
        Clock clock = Mock(Clock)

        when:
        Long currentTime = clock.currentTimeMillis()

        then:
        currentTime == 1
        1 * clock.currentTimeMillis() >>> [1, 2, 3]
    }
}

interface Clock {
    Long currentTimeMillis();
}