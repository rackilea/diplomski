import org.apache.spark.mllib.linalg.{SparseVector, Vector} 

def vectorsToMaps(vocabulary: Array[String]) = {
  udf((v: Vector) => {
    val sv = v.toSparse
    sv.indices.map(i => (vocabulary(i) -> sv(i))).toMap
  })
}

counted.select(vectorsToMaps(cvModel.vocabulary)($"features")
  .alias("freqs"))
  .show(3, false)

// +------------------------------------------------------------------+
// |freqs                                                             |
// +------------------------------------------------------------------+
// |Map(game -> 2.0, life -> 1.0, learn -> 1.0, everlasting -> 1.0)   |
// |Map(moment -> 1.0, special -> 1.0, unexamined -> 1.0, time -> 1.0)|
// |Map(life -> 1.0, live -> 1.0, worth -> 1.0)                       |
// +------------------------------------------------------------------+