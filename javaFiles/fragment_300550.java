@Test
public void insertPrioritatAltaTest() {
    HeapQueue hq = new HeapQueue();
    hq.insert(new Priority("A"), 1);
    hq.insert(new Priority("C"), 2);
    hq.insert(new Priority("B"), 3);

    assertEquals(hq.pop(), 1);
    assertEquals(hq.pop(), 3);
    assertEquals(hq.pop(), 2);
}