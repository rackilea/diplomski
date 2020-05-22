package simpletest

import java.util.HashSet

import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Prop._
import org.scalacheck.util.Buildable
import org.scalacheck.{Arbitrary, Gen, Properties}

import scala.collection.JavaConverters._
import scala.collection._
import scala.language.implicitConversions


class SimpleSpecification extends Properties("Simple") {

  implicit def buildableHashSet[T]: Buildable[T, HashSet[T]] = new Buildable[T, HashSet[T]] {
    def builder = new mutable.Builder[T, HashSet[T]] {
      val al = new HashSet[T]

      def +=(x: T) = {
        al.add(x)
        this
      }

      def clear() = al.clear()

      def result() = al
    }
  }

  implicit def hashSetTraversable[T](hashSet: HashSet[T]): Traversable[T] = {
    hashSet.asScala
  }

  implicit val intHashSetGen: Arbitrary[HashSet[Int]] =
    Arbitrary(Gen.containerOf[HashSet, Int](arbitrary[Int]))

  property("simple") =
    forAll { (a: HashSet[Int]) =>
      a.size() == 1
    }

}