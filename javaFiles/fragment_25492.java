struct s0 {};

struct s1
{
    virtual void f1() {}
};

struct s2
{
    virtual void f1() {}
    virtual void f2() {}
};

struct s3
{
    virtual void f1() {}
    virtual void f2() {}
    virtual void f3() {}
};

int main()
{
    std::cout << "s0: " << sizeof(s0) << '\n';
    std::cout << "s1: " << sizeof(s1) << '\n';
    std::cout << "s2: " << sizeof(s2) << '\n';
    std::cout << "s3: " << sizeof(s3) << '\n';
}