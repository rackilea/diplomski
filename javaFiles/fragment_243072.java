@Test
public void testAllowedExclusionReason()
{
  Assume.assumeThat(reason, Matchers.anyOf(Matchers.nullValue(), Matchers.isIn(allowedReasons)));
  final ExcludedPeriodFact test = new ExcludedPeriodFact();
  test.setExclusionReason(reason);
  Assert.assertEquals("getExclusionReason()", reason, test.getExclusionReason());
}