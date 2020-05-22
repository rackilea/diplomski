import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.ann.Library;
import org.bridj.ann.Runtime;
import org.bridj.cpp.CPPRuntime;

// Generated with http://code.google.com/p/jnaerator/
@Library(CPP_Collateral.JNA_LIBRARY_NAME)
@Runtime(CPPRuntime.class)
public class CPP_Collateral {
public static final String JNA_LIBRARY_NAME = "dummy";

static {
    // In eclipse, the DLL will be loaded from a resource folder
    // Else, one should add a program property: -Djava.library.path
    BridJ.addLibraryPath("src/main/resources/DLL");

    BridJ.register();
}

/**
 * My dummy.dll has one method:
 * int multiply(double multiplier, int size, double* const vector)
 */
public static native int multiply(double multiplier, int size, Pointer<Double> vector);
}