open class Base {
    open fun test(){}
}

open class DerivedA : Base(){
    final override fun test(){}
}

class DerivedB : DerivedA() {
    override fun test(){} //error: 'test' in 'DerivedA' is final and cannot be overriden
}