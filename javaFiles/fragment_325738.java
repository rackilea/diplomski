object ScalaTester extends App {
  val random = new Random
  test((0 until 1000000).toList map {_ => s"type${random nextInt 10}"})

  def test(lines: List[String]) {
    val start = Platform.currentTime
    val m = lines groupBy {
      case s if s startsWith "type1" => "type1"
      case s if s startsWith "type2" => "type2"
      case _ => ""
    }
    println(s"Total type1: ${m("type1").size}; Total type2: ${m("type2").size}; time=${Platform.currentTime - start}")
  }
}