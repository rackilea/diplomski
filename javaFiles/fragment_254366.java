trait HelloWorld extends Library {

  def GetData(m: WString) : Data.ByValue;

}

object HelloJNA {

  def main(args:Array[String]):Unit = {

    val libc   = Native.load( "HelloWorld", classOf[HelloWorld] )

    var result = libc.GetData( new WString("I am passing String!") )
    println("Result: " + result.field);

  }
}