Compiled from "InterfaceType.java"
public interface com.sun.jdi.InterfaceType extends com.sun.jdi.ReferenceType {
  public abstract java.util.List<com.sun.jdi.InterfaceType> superinterfaces();
  public abstract java.util.List<com.sun.jdi.InterfaceType> subinterfaces();
  public abstract java.util.List<com.sun.jdi.ClassType> implementors();
  public com.sun.jdi.Value invokeMethod(com.sun.jdi.ThreadReference, com.sun.jdi.Method, java.util.List<? extends com.sun.jdi.Value>, int) throws com.sun.jdi.InvalidTypeException, com.sun.jdi.ClassNotLoadedException, com.sun.jdi.IncompatibleThreadStateException, com.sun.jdi.InvocationException;
}