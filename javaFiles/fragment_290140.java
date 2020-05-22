StackTraceElement ste = exception.getStackTrace()[0];

Class<?> c = Class.forName(ste.getClassName());
String mname = ste.getMethodName();

// NOTE:
// Exceptions thrown in constructors have a method name of "<init>"
// Exceptions thrown in static initialization blocks have a method name of
//    "<cinit>"

if ("<init>".equals(mname)) {
    // Constructors are the possible "methods", all of these:
    c.getConstructors();
} else if ("<cinit>".equals(mname)) {
    System.out.println("Thrown in a static initialization block!");
} else {
    // Thrown from a method:
    for (Method m : c.getMethods()) {
        if (m.getName().equals(mname)) {
            System.out.println("Possible method: " + m);
        }
    }
}