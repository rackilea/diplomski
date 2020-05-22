public abstract class ExAbstract { public abstract void abstractmethod() {...} }
public class ExampleA extends ExAbstract { @Override... }
public class ExampleB extends ExAbstract { @Override... }
...

List<ExAbstract> list = new ArrayList<>();
list.add(new ExampleA());
list.add(new ExampleB());
...