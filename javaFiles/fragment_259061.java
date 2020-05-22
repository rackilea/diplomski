val newCentroids = {
  val temp = pointsGroup.mapValues(ps => average(ps.toSeq)).collectAsMap()
  val nMissing = K - temp.size 
  val sample = data.takeSample(false, nMissing, seed)
  var c = -1
  (for (i <- 0 until K) yield {
   val point = temp.getOrElse(i, {c += 1; sample(c) })
   (i, point)
  }).toMap      
}