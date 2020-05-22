interface MyInterface <T, I, O>
{
    T method(I arg);
}

abstract class MyAbstractClass <O, I> implements MyInterface<List<O>, List<I> , O>
{
    @Override
    public abstract List<O> method(List<I> arg);
}

class MyImplementation extends MyAbstractClass <String , Integer>
{
    @Override
    public List<String> method(List<Integer> arg) {
        // ... implementation
    }
}