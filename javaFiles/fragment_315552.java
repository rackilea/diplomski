public interface Func {

boolean func(Foo foo);

}

public class Test1 implements Func {

@Override
public boolean func(Foo foo) {
  return doSomeStuff();
}

...

_foos[0] = getTest(new Test1());