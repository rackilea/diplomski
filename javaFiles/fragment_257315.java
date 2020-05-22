@Test
fun testCase{
....
val mockCompanionObj: DummyCompanion.Companion = mock()
val wrapper = DummyWrapper()

whenever(wrapper.foo).thenReturn(mockCompanionObj)
wrapper.callCompanionMethod()
verify(mockCompanionObj).someCompanionMethod()
....
}