class DerivedClass extends BaseClass< DerivedInterface > {
    void derivedFunc1( DerivedInterface foo ) {
        baseFunc1( foo );
    }
    void derivedFunc2( Collection< DerivedInterface > foo ) {
        baseFunc2( foo );
    }
    void derivedFunc3( Collection< DerivedInterface > foo ) {
        baseFunc3( foo );
    }
}