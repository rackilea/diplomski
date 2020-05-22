abstract class MyEnum{

   type Value     //define me to be the value type for this MyEnum

   private var _values:List[Value] = Nil
   def values = _values    
   protected def add(newValue:Value) = {
      _values = newValue::_values
      newValue
   }
}

object DayOfWeek extends MyEnum{
   class Value(val dayNum:Int)
   val SUNDAY    = add(new Value(1))
   val MONDAY    = add(new Value(2))
   val TUESDAY   = add(new Value(3))
   val WEDNESDAY = add(new Value(4))
   val THURSDAY  = add(new Value(5))
   val FRIDAY    = add(new Value(6))
   val SATURDAY  = add(new Value(7))
}