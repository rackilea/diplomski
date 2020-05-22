class AbstractTest {
public:
    virtual void test() = 0;
};


class ConcreteTest : AbstractTest {
public:
    void test() {
        //Implementation here...
    }
};