@Mock
private Model model;

@Test
public void showAddAbsencePagetest() {
    // Should probably be initialized in a @Before method,
    // Initialized here for clarity only
    AjoutAbscenceControler ajoutAbscenceControler = new AjoutAbscenceControler();

    assertEquals("addAbsence", ajoutAbscenceControler.showAddAbsencePage(model));

    Mockito.verify(model).addAttribute(eq("Absence"), any(Absence.class));
}