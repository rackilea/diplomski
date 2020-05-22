import org.junit.runner.manipulation.Filter;
import org.junit.runner.Description;

public final class AntCLFilter extends Filter {
    private static final String TEST_CASES = "tests";
    private static final String ANT_PROPERTY = "${tests}";
    private static final String DELIMITER = "\\,";
    private String[] testCaseNames;

    public AntCLFilter() {
        super();
        if (hasTestCases()) testCaseNames = getTestCaseNames();
    }

    public String describe() {
        return "Filters out all tests not explicitly named in a comma-delimited list in the system property 'tests'.";
    }

    public boolean shouldRun(Description d) {
        String displayName = d.getDisplayName();
        // cut off the method name:
        String testName = displayName.substring(0, displayName.indexOf('('));
        if (testCaseNames == null) return true;

        for (int i = 0; i < testCaseNames.length; i++)
            if (testName.equals(testCaseNames[i]))
                return true;
        return false;
    }

    /**
     * Check to see if the test cases property is set. Ignores Ant's
     * default setting for the property (or null to be on the safe side).
     **/
    public static boolean hasTestCases() {
        return
            System.getProperty( TEST_CASES ) == null ||
            System.getProperty( TEST_CASES ).equals( ANT_PROPERTY ) ?
            false : true;
    }

    /**
     * Create a List of String names of test cases specified in the
     * JVM property in comma-separated format.
     *
     * @return a List of String test case names
     *
     * @throws NullPointerException if the TEST_CASES property
     * isn't set
     **/
    private static String[] getTestCaseNames() {

        if ( System.getProperty( TEST_CASES ) == null ) {
            throw new NullPointerException( "Test case property is not set" );
        }

        String testCases = System.getProperty( TEST_CASES );
        String[] cases = testCases.split(DELIMITER);

        return cases;
    }
}

import org.junit.internal.runners.*;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;

public class FilteredRunner extends TestClassRunner {

    public FilteredRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
        Filter f = new AntCLFilter();
        try {
            f.apply(this);
        } catch (NoTestsRemainException ex) {
            throw new RuntimeException(ex);
        }
    }
}