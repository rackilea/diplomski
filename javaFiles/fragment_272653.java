class Base {
    Base/*actually this type*/ clone() { … }
}
class SubClass extends Base {
    SubClass/*actually this type*/ clone() { … }
}
class GrandChild extends SubClass {
    GrandChild/*actually this type*/ clone() { … }
}