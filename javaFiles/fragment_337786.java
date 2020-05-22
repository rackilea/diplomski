$ javap test.B
public interface test.B extends test.A{
    public abstract void z();
}

$ javap test.D
public abstract class test.D extends java.lang.Object implements test.C{
    public scala.runtime.BoxedUnit z();
    public java.lang.Object z();
    public void z();
    public test.D();
}