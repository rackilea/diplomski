@Test
public void testSuccesor() {
   int[] start = {2,2,5};
   int[] expected = {2,2,6};

   int[] actual = callSuccesorMethod(start);

   assertArrayEquals(expected, actual);
}