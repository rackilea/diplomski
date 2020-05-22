public interface StackInt<T> {
       public T pop();
       public void push(T node);
}

public class Stack<T> implements StackInt<T>
{
    ...
}