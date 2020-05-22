import shapeless._, Nat._

trait Factorial[N <: Nat] { type Value <: Nat }

implicit object fact0 extends Factorial[_0] { type Value = _0 }
implicit object fact1 extends Factorial[_1] { type Value = _1 }

implicit def factN[N <: Nat, X <: Nat, Y <: Nat, Z <: Nat](implicit
  nf: Factorial[N]       { type Value = X },
  sf: Factorial[Succ[N]] { type Value = Y },
  sum: ops.nat.Sum.Aux[X, Y, Z]
) = new Factorial[Succ[Succ[N]]] { type Value = Z }