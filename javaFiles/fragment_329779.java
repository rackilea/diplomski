class Base
{
public:
   void f(int) { }
};

class Derived : public Base
{
public:
using Base::f; // this line allow you to use function from base class
   void f(char *) { }
};

int main()
{
   Derived d;
   d.f(5); // This line throws a compilation error
}