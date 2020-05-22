@Parameters
public static Collection<Object[]> data() {
  Collection<Object[]> result = new ArrayList<>();

  for (TestCase testCase : getTestCaseList()) {
    result.add(new Object[] {testCase});
  }

  return result;
}