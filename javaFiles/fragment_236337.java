@Test public void addGradeTest2() {
  String[] myGrades1 = {"a90", "a100", "q90", "q80", "p100", "e87.5"};
  WeightedGrades2 wg = new WeightedGrades2("Anakin Skywalker", 7, myGrades1);

  int sizeBeforeIncrease = wg.getGrades().length;

  wg.increaseGradesCapacity();

  int sizeAfterIncrease = wg.getGrades().length;

  Assert.assertTrue("Expecting size after increase to be larger.", 
                       sizeAfterIncrease > sizeBeforeIncrease);
}