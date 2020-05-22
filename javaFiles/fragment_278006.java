object Unit extends Enumeration {
  abstract class UnitValue(var name: String) extends Val(name) {
    def m: Unit
  }
  val G = new UnitValue("g") {
    def m {
        println("M from G")
    }
  }
  val KG = new UnitValue("kg") {
    def m {
        println("M from KG")
    }
  }
}