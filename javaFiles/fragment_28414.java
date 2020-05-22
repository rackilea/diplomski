@Test(expected = StudentException.class)
public void testImportStudent() {
    try {
        String txtline = "1, Name, Name";
        Source test = studentMain.importStudent(txtline); //Throw error
        txtline = "1, Name";
        test = percursoGestor.importSource(line);
        assertEquals("Error inserting ID", 3, test.getStudentID());
        assertEquals("Error inserting Name", "Nothing", test.getStudentName());
    } catch (Exception e) {
        // verify exception
    }
}