public void testhashCode() {
    Heap12<Integer> sampleHeap = new Heap12<Integer>(); //instantiate two
    sampleHeap.add(100); //add two vales
    sampleHeap.add(0);
    Heap12<Integer> sampleHeap2 = new Heap12<Integer>(sampleHeap);
    assertEquals(sampleHeap.hashCode(), sampleHeap2.hashCode());
    System.out.println(Arrays.toString(sampleHeap.listArr));
    sampleHeap.add(1000); //make the heaps uneven
    System.out.println(Arrays.toString(sampleHeap.listArr));
    assertFalse(sampleHeap.hashCode() == sampleHeap2.hashCode());
    sampleHeap.remove(); //remove the values added
    System.out.println(Arrays.toString(sampleHeap.listArr));

    assertTrue(sampleHeap2.equals(sampleHeap));
    assertTrue(sampleHeap.hashCode() == sampleHeap2.hashCode());
}