@Test
public static void testGetStats() {
  List<Double> testList = Arrays.asList("1.0, 2.0, 3.0");
  Stats stats = MainClass.getStatsFromVals(testList);
  assertEquals(1.0, stats.min);
  assertEquals(3.0, stats.max);      
  assertEquals(2.0, Math.rint(stats.avg)); // risky FP math
}