import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import jdepend.framework.DependencyConstraint;
import jdepend.framework.JDepend;
import jdepend.framework.JavaPackage;
import junit.framework.TestCase;

public class DependencyTest extends TestCase {

    private JDepend jdepend;

    @Override
    public void setUp() throws IOException {
        jdepend = new JDepend();
        jdepend.addDirectory("build/classes/com");
    }

    public void testDomainDependsOnInfastructure_ShouldBeTrue() {
        DependencyConstraint constraint = new DependencyConstraint();

        JavaPackage distribution = constraint.addPackage("com.distribution");
        JavaPackage domainPackage = constraint.addPackage("com.domain");
        JavaPackage infastructurePackage = constraint.addPackage("com.infrastructure");

        distribution.dependsUpon(domainPackage);
        domainPackage.dependsUpon(infastructurePackage);
        jdepend.analyze();

        Collection<JavaPackage> actual = new ArrayList<JavaPackage>();
        actual.add(domainPackage);
        actual.add(distribution);
        actual.add(infastructurePackage);

        assertEquals("Domain doesn't depend on Infrastructure layer", true, constraint.match(actual));
    }

}