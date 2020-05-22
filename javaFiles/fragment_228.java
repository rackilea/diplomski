@Rule public ExpectedException thrown= ExpectedException.none();

@Test
public void myTest() {
    thrown.expect( Exception.class );
    thrown.expectMessage("Init Gold must be >= 0");

    rodgers = new Pirate("Dread Pirate Rodgers" , -100);
}