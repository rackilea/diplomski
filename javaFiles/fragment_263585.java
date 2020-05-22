val a = ""
val b = ""
(a.codePoints.toArray zip b.codePoints.toArray).forall { 
  case (x, y) => 
  Character.toLowerCase(x) == Character.toLowerCase(y) 
}