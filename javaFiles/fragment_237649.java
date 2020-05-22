public class MyTest
{
    @Test public void testUsingAMockUp()
    {
        new MockUp<SomeClass>() { @Mock boolean getValue() { return true; } };

        // Call code under test which then calls SomeClass#getValue().
    }

    @Test public void anotherTestUsingAMockUp()
    {
        new MockUp<SomeClass>() { @Mock boolean getValue() { return false; } };

        // Call code under test which then calls SomeClass#getValue().
    }

    @Test public void testUsingExpectations(@NonStrict final SomeClass mock)
    {
        new Expectations() {{ mock.getValue(); result = true; }};

        // Call code under test which then calls SomeClass#getValue().
    }

    @Test public void anotherTestUsingExpectations(
        @NonStrict final SomeClass mock)
    {
        // Not really needed because 'false' is the default for a boolean:
        new Expectations() {{ mock.getValue(); result = false; }};

        // Call code under test which then calls SomeClass#getValue().
    }
}