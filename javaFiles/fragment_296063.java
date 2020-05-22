val a = Seq(1,2,3)
val b = Seq(4,5,6)
for ((i, j) <- a.zip(b)) {
  println(s"$i $j")
}
// It prints out:
// 1 4
// 2 5
// 3 6