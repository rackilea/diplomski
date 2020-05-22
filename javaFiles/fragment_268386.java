class Impl;
class SecondClass;
class FirstClass
{
    std::shared_ptr<Impl> pimpl;
public:
    FirstClass();
    SecondClass RoutineA(...);
    ...
}

class SecondClass
{
    std::shared_ptr<Impl> pimpl;
    friend class FirstClass;
    SecondClass(const std::shared_ptr<Impl>& impl) : pimpl(impl);
public:
    void RoutineB(....);
}

SecondClass FirstClass::RoutineA(...)
{
    // Do stuff
    return SecondClass(pimpl);
}