public abstract class MyProducer<T> {...}

@Named
@SessionScoped
public class MyStringProducer extends MyProducer<String> {}

@Named
@SessionScoped
public class MyIntegerProducer extends MyProducer<Integer> {}