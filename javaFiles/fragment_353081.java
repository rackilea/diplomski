λ scalac -Xprint:jvm Foo.scala
[[syntax trees at end of                       jvm]] // Foo.scala
package com.testing {
  class Foo extends Object {
    def intsNullTuple(): Tuple2 = new Tuple2$mcII$sp(scala.Int.unbox(null), 2);
    def intAndStringNullTuple(): Tuple2 = new Tuple2(scala.Int.box(scala.Int.unbox(null)), "2");
    def <init>(): com.testing.Foo = {
      Foo.super.<init>();
      ()
    }
  }
}