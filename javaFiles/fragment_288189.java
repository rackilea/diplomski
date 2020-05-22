private fun <T> anyObject(): T {
    Mockito.anyObject<T>()
    return uninitialized()
}

private fun <T> uninitialized(): T = null as T

@Test
fun myTest() {
    `when`(mockedBackend).login(anyObject())).thenAnswer { ... }
}