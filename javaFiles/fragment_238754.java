@Test
public void someTestMethod(){

    Mockito.when(mAppConfiguration.getActiveProfile()).thenReturn("some value");

    /** actual test goes here**/
}