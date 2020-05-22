Method equals: (Any)Boolean is structural equality, where two instances
are equal if they both belong to the case class in question and they have equal
(with respect to equals) constructor arguments.

class AnyRef extends Any {
    def equals(that: Any): Boolean = this eq that
    final def eq(that: AnyRef): Boolean = . . . // reference equality