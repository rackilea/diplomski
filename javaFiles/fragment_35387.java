@Test
public void testSetStudent() {
    main = new Main();
    main.setStudent("newStudent");
    assertEquals("Test setStudent", "newStudent", main.getStudent());
}