scala> implicit val xxx = new collection.generic.CanBuildFrom[Array[Int], Days.Value, Days.ValueSet] {
     | def apply() = Days.ValueSet.newBuilder
     | def apply(from: Array[Int]) = apply()
     | }
xxx: scala.collection.generic.CanBuildFrom[Array[Int],Days.Value,Days.ValueSet] = $anon$1@6b474074

scala> (2 to 5) map (_ => Days.T)
res4: scala.collection.immutable.IndexedSeq[Days.Value] = Vector(T, T, T, T)

scala> (2 to 5) map (Days(_))
res5: scala.collection.immutable.IndexedSeq[Days.Value] = Vector(W, Th, F, Sa)