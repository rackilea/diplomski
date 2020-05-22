@Test
    public void testSuchAutorGrenzwert() {
        try {
            bibliothek.suchAutor("");
        } catch (IllegalArgumentException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
    }