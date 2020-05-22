import java.lang.invoke.*;

public class ManualLambda {
  public static void main(String[] args) throws Throwable {
    MethodHandles.Lookup me=MethodHandles.lookup();
    MethodType t=MethodType.methodType(void.class);
    MethodType rt=MethodType.methodType(Runnable.class);
    CallSite site = LambdaMetafactory.metafactory(
      me, "run", rt, t, me.findStatic(ManualLambda.class, "sayHello", t), t);
    MethodHandle factory=site.getTarget();
    Runnable r=(Runnable)factory.invoke();

    System.out.println("created lambda: "+r);
    r.run();
  }
  private static void sayHello() {
      System.out.println("hello world");
  }
}