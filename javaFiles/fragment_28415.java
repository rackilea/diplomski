@Test(expected = StudentException.class)
public void testImportStudent_incorrectInput() {
    String txtline = "1, Name, Name";
    Source test = studentMain.importStudent(txtline);
}

@Test
public void testImportStudent_correctInput() {
    String txtline = "1, Name";
    Source test = percursoGestor.importSource(line);
    assertEquals("Error inserting ID", 3, test.getStudentID());
    assertEquals("Error inserting Name", "Nothing", test.getStudentName());    
}