class P {
  class C { }
}

val x = new P
val y = new P
var z = new x.C
z = new y.C // type error; x.C and y.C are distinct types