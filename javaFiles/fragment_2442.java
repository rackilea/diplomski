@Test
public void testClassA(@Mocked File myDir)
{
    new Expectations() {{ myDir.list(); result = "file1-bla.txt"; }};

    String returnedFileName = new ClassA().publicMethodThatCallsFindFile("file1.txt");

    assertEquals("file1-bla.txt", returnedFileName);
}