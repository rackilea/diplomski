interface IFileHandler
{
    // If this interface needs to talk about keys and values, it
    // does so using only java.lang.Object.
}

public class fileHandler<Key extends Object, Value extends Object>
    implements IFileHandler
{
    // ...
}

public class A extends fileHandler<String, String>
{
    // ...
}

public class B extends fileHandler<String, String[]>
{
    // ...
}

IFileHandler file;

if (...) {
    file = new A();
} else {
    file = new B();
}