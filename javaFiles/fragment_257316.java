@Test
 fun testCompanionObject() {
    //Mock the companion object
    mockkObject(DummyCompanion.Companion)

    //define the stubbing bechavior of a companion object method
    every { DummyCompanion.Companion.companionMethod() } answers { stubMethod() }

    val testObject = DummyWrapper()

    //Call a method that calls the companion object method
    //You can verify stubMethod() is called
    testObject.callCompanionMethod()

    verify(exactly = 1) { DummyCompanion.someCompanionMethod() }
}