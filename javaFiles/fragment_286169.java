class thing_interface {
public:
    virtual ~thing_interface() {}
    virtual void foo() =0; //pure virtual function
};
class other_interface {
public:
    virtual ~other_interface () {}
    virtual void bar() =0; //pure virtual function
};

class thing_impl : public thing_interface, public other_interface { 
protected:
    int member;
public:
    thing_impl() : member(0) {}
    virtual ~thing_impl() {};
    virtual void foo() { std::cout << "FOO!\n";}
    virtual void bar() { std::cout << "BAR!\n";}
};