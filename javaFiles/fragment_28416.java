@Test
public void testImportStudent() {
    String txtline = "1, Name, Name";
    Source test;
    try {
        test = studentMain.importStudent(txtline);
        // Make sure that the test fails when no exception is thrown
        fail();
    } catch (Exception e) {
        // Check for the correct exception type
        assertTrue(e instanceof StudentException);
    }
    // Other checks
    txtline = "1, Name";
    test = percursoGestor.importSource(line);
    assertEquals("Error inserting ID", 3, test.getStudentID());
    assertEquals("Error inserting Name", "Nothing", test.getStudentName());
}