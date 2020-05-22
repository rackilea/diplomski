type M = Map[Class[_ <: Throwable], ExceptionMapper[_ <: Throwable]]

class A[E <: Throwable]
(
  mappers: M
) {
}

class B[CompletionException]
(
  mappers: M
) extends A(mappers) {
}