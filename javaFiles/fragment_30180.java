@Test
public void exampleTestUsingAMockUp()
{
    new MockUp<UnMockableType>() {
        @Mock
        void preventControlFlowInfluenceThroughMocking() {}
    };

    TestedClass.testedMethod();
}