// Java using "object references":
public static void foo(String bar)
{
    bar = "hello world";
}

public static void main(String[] argv)
{
    String bar = "goodbye world";
    foo(bar);
    System.out.println(bar); // prints "goodbye world"
}

// C++ using "references":
void foo(std::string& bar)
{
    bar = "hello world";
}

int main()
{
    std::string bar = "goodbye world";
    foo(bar);
    std::cout << bar << std::endl; // prints "hello world"
}

// C++ using pointers:
void foo(std::string* bar)
{
    bar = new std::string("goodbye world");
    delete bar; // you don't want to leak
}

int main()
{
    std::string bar = "goodbye world";
    foo(&bar);
    std::cout << bar << std::endl; // prints "hello world"
}