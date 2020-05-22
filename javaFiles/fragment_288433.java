class DerivedClass extends BaseClass {
    void derivedFunc1( DerivedInterface foo ) {
        baseFunc1( foo );
    }
    void derivedFunc2( Collection< DerivedInterface > foo ) {
        baseFunc2( foo );
    }
    void derivedFunc3( Collection< BaseInterface > foo ) {
        baseFunc3( foo );
    }
}