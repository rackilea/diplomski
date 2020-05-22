@Test
public void isInt() {
    assertTrue(obj.isInt(new Integer(1)));
}

@Test
public void isNotInt() {
    for (Object obj : new Object[] {new Short(1), new Boolean(true), new Long(1), new Chaeracter('a')}) {
        assertFalse(obj.isInt(obj));
    }

}