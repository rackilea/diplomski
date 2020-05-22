@Test
public void testMethod1() {
    DependedOnComponent mockDOC = mock(DependedOnComponent.class);

    // When method2() is called you control the value returned
    when(mockDOC.method2(1)).thenReturn(2);

    assertThat(testee.method1(mockDOC), equalTo(2));
}