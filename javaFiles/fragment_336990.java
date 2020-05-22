package demo

import grails.test.mixin.*
import org.junit.*

@TestFor(Timer)
class TimerTests {

    @Before
    void setUp() {
        // Ensure we can invoke validate() on our domain object.
        mockForConstraintsTests(Timer)
    }

    void testHours(){
        Timer m = new Timer(hours: 1)
        assertTrue m.validate()

        m.hours = 1.5;
        assertTrue m.validate()

        m.hours = 1.3;
        assertFalse m.validate()
        assertEquals 'validator', m.errors['hours']

        // Test Min constraint
        m.hours = 0;
        assertFalse m.validate()
        assertEquals 'min', m.errors['hours']

        // Test non numbers
        m = new Timer(hours: 'ss')
        assertFalse m.validate()
    }
}