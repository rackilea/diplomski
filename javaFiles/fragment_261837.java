public abstract class UnitTestErrorController {
    // Abstract class which has the rule.
    @Rule
    public ErrorCollector collector = new ErrorCollector();

}

public class CelebrityTest extends UnitTestErrorController {
    // Whenever a failed test takes places, ErrorCollector handle it.
}

public class NormalPeopleTest extends UnitTestErrorController {
    // Whenever a failed test takes places, ErrorCollector handle it.
}