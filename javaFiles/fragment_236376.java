public class SomeTest {
  @Rule
  public ConditionalIgnoreRule rule = new ConditionalIgnoreRule();

  @Test
  @ConditionalIgnore( condition = IgnoredByTeamA.class )
  public void testIgnoredByTeamA() {
       ...
  }
}

public class IgnoredByTeamA implements IgnoreCondition {
  public boolean isSatisfied() {
    return true;
  }
}