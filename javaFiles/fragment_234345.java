object FuncConversions {
  implicit def func2function[A,R]( fn: (A) => R ) =
    new Func[A,R] {
      def f(a: A) = fn(a)
    }
}