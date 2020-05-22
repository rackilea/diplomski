object IfCaseTernBench extends Benchcoat [List[Int], Seq[Int]] {

  type I=List[Int]
  type O=Seq[Int]
  val name = "CaseTern"
  /** We return a List of random Ints numbers here. */
  def iGenerator (n: Int) : I = (for (x <- 1 to n) yield math.abs (random.nextInt (3))).toList
  def takePart (li: I, n: Int) : I = li.take (n) 

  /* Each algorithm is called by a mapping to a static method.  */
  def ifTest   (i: I) : O = i.map (CaseTernIf.aORbIf) 
  def caseTest (i: I) : O = i.map (CaseTernIf.aORbCase) 
  def ternTest (i: I) : O = i.map (CaseTernIf.aORbTern) 

  // Map of Test names -> methods to test
  val list2bench: List [(String, I => O)] = List (
       "if test"    -> ifTest _
     , "case test"  -> caseTest _
     , "tern test"  -> ternTest _
  )

  def test = { 
     list2bench.foreach (algo => println (algo._2))
  }
}