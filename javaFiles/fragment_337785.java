package test

abstract class D[U <: Unit] extends A[U] with C {
  override def z: U = (this: B).z.asInstanceOf[U]
}

abstract class E extends D[Unit] {}