private fun <T> anyObject(): T {
    return Mockito.anyObject<T>()
}

@Test
fun myTest() {
    `when`(mockedBackend).login(anyObject())).thenAnswer { ... }
}