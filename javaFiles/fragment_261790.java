scala> val r = (""""([^"\p{Cntrl}\\]*+(?:\\[\\'"bfnrt])*+(?:\\u[a-fA-F0-9]{4})*+)*+"""").r
r: scala.util.matching.Regex = "([^"\p{Cntrl}\\]*+(?:\\[\\'"bfnrt])*+(?:\\u[a-fA-F0-9]{4})*+)*+"

scala> r.pattern.matcher("\"" + "\\ns" * 2500 + "\"").lookingAt
res4: Boolean = true

scala> r.pattern.matcher("\"" + "s" * 2500 + "\"").lookingAt
res5: Boolean = true