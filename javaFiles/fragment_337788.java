package test

trait A[+Z] { def z(): Z }
trait B extends A[Unit] { def z(): Unit = println("Ok") }
trait C extends B {}

class D extends C {
  private var myI: I
  def i = myI
  def bind(newI: I) { myI = newI }
  def doJavaThing = i.doThing
}