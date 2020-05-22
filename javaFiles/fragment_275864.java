val tl1 = new TimeLord(x => List.range(0,x))(_.sum)  // Should be linear
// Try list sizes 100 to 10000, with each run taking at least 0.1s;
// use 10 different sizes and 10 repeats of each size
scala> tl1.alpha( tl1.multibench(100,10000,0.1,10,10) )
res0: ((Double, Double), (Double, Double)) = ((1.0075537890632216,7.061397125245351E-9),(0.8763463348353099,1.102663784225697))

val longList = List.range(0,100000)
val tl2 = new TimeLord(x=>x)(longList.apply)    // Again, should be linear
scala> tl2.alpha( tl2.multibench(100,10000,0.1,10,10) )
res1: ((Double, Double), (Double, Double)) = ((1.4534378213477026,1.1325696181862922E-10),(0.969955396265306,1.8294175293676322))

// 1.45?!  That's not linear.  Maybe the short ones are cached?
scala> tl2.alpha( tl2.multibench(9000,90000,0.1,100,1) )
res2: ((Double, Double), (Double, Double)) = ((0.9973235607566956,1.9214696731124573E-9),(0.9486294398193154,1.0365312207345019))

// Let's try some sorting
val tl3 = new TimeLord(x=>Vector.fill(x)(util.Random.nextInt))(_.sorted)
scala> tl3.alpha( tl3.multibench(100,10000,0.1,10,10) )
res3: ((Double, Double), (Double, Double)) = ((1.1713142886974603,3.882658025586512E-8),(1.0521099621639414,1.3392622111121666))
// Note the log(n) term comes out as a fractional power
// (which will decrease as the sizes increase)

// Maybe sort some arrays?
// This may take longer to run because we have to recreate the (mutable) array each time
val tl4 = new TimeLord(x=>Array.fill(x)(util.Random.nextInt), false)(java.util.Arrays.sort)
scala> tl4.alpha( tl4.multibench(100,10000,0.1,10,10) )
res4: ((Double, Double), (Double, Double)) = ((1.1216172965292541,2.2206198821180513E-8),(1.0929414090177318,1.1543697719880128))

// Let's time something slow
def kube(n: Int) = (for (i <- 1 to n; j <- 1 to n; k <- 1 to n) yield 1).sum
val tl5 = new TimeLord(x=>x)(kube)
scala> tl5.alpha( tl5.multibench(10,100,0.1,10,10) )
res5: ((Double, Double), (Double, Double)) = ((2.8456382116915484,1.0433534274508799E-7),(2.6416659356198617,2.999094292838751))
// Okay, we're a little short of 3; there's constant overhead on the small sizes