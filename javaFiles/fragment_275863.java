class TimeLord[A: ClassManifest,B: ClassManifest](setup: Int => A, static: Boolean = true)(run: A => B) {
  @annotation.tailrec final def exceed(time: Double, size: Int, step: Int => Int = _*2, first: Int = 1): (Int,Double) = {
    var i = 0
    val elapsed = 1e-9 * {
      if (static) {
        val a = setup(size)
        var b: B = null.asInstanceOf[B]
        val t0 = System.nanoTime
        var i = 0
        while (i < first) {
          b = run(a)
          i += 1
        }
        System.nanoTime - t0
      }
      else {
        val starts = if (static) { val a = setup(size); Array.fill(first)(a) } else Array.fill(first)(setup(size))
        val answers = new Array[B](first)
        val t0 = System.nanoTime
        var i = 0
        while (i < first) {
          answers(i) = run(starts(i))
          i += 1
        }
        System.nanoTime - t0
      }
    }
    if (time > elapsed) {
      val second = step(first)
      if (second <= first) throw new IllegalArgumentException("Iteration size increase failed: %d to %d".format(first,second))
      else exceed(time, size, step, second)
    }
    else (first, elapsed)
  }

  def multibench(smallest: Int, largest: Int, time: Double, n: Int, m: Int = 1) = {
    if (m < 1 || n < 1 || largest < smallest || (n>1 && largest==smallest)) throw new IllegalArgumentException("Poor choice of sizes")
    val frac = (largest.toDouble)/smallest
    (0 until n).map(x => (smallest*math.pow(frac,x/((n-1).toDouble))).toInt).map{ i => 
      val (k,dt) = exceed(time,i)
      if (m==1) i -> Array(dt/k) else {
        i -> ( (dt/k) +: (1 until m).map(_ => exceed(time,i,first=k)).map{ case (j,dt2) => dt2/j }.toArray )
      }
    }.foldLeft(Vector[(Int,Array[Double])]()){ (acc,x) =>
      if (acc.length==0 || acc.last._1 != x._1) acc :+ x
      else acc.dropRight(1) :+ (x._1, acc.last._2 ++ x._2)
    }
  }

  def alpha(data: Seq[(Int,Array[Double])]) = {
    // Use Theil-Sen estimator for calculation of straight-line fit for exponent
    // Assume timing relationship is t(n) = A*n^alpha
    val dat = data.map{ case (i,ad) => math.log(i) -> ad.map(x => math.log(i) -> math.log(x)) }
    val slopes = (for {
      i <- dat.indices
      j <- ((i+1) until dat.length)
      (pi,px) <- dat(i)._2
      (qi,qx) <- dat(j)._2
    } yield (qx - px)/(qi - pi)).sorted
    val mbest = slopes(slopes.length/2)
    val mp05 = slopes(slopes.length/20)
    val mp95 = slopes(slopes.length-(1+slopes.length/20))
    val intercepts = dat.flatMap{ case (i,a) => a.map{ case (li,lx) => lx - li*mbest } }.sorted
    val bbest = intercepts(intercepts.length/2)
    ((mbest,math.exp(bbest)),(mp05,mp95))
  }
}