class T(value: Any) extends ClassfileAnnotation

object Holder {
   final val as = Array(1, 2, 3)
   final val a = 1
} 

@T(Holder.a)
@T(Holder.as)  // annot.scala:9: error: annotation argument needs to be a constant; found: Holder.as
class Target