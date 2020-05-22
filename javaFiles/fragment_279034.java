@Test
public void mainTest() {
    Integer[] data1 = { 2, 22, 33, 20, 222 };
    assertEquals(222, findNumberInArrayWithTheMostOccurrences(data1, 2));

    //Check if it returns the first element of the array when all numbers do not contain it
    assertEquals(2, findNumberInArrayWithTheMostOccurrences(data1, 215));

    Integer[] data2 = { 2, 2224, 3351, 20141414, 22214 };
    assertEquals(20141414, findNumberInArrayWithTheMostOccurrences(data2, 14));
}