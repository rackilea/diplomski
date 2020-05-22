class Main
{
    def test (x: Any) = x match {
        case "Hello" => println ("Hello World")
        case e: String => println ("String")
        case i: Int => println ("Int")
        case _ => println ("Something else")
    }
}