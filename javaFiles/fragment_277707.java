@Before
fun mockAllUriInteractions() {
    staticMockk<Uri>().mock()
    every { Uri.parse("http://test/path") } returns Uri("http", "test", "path")    //This line can also be in any @Test case
}

@After
fun unmockAllUriInteractions() {
    staticMockk<Uri>().unmock()
}