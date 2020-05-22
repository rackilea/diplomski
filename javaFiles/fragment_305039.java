sealed trait Compiler {
  def printInstruction: String = this match {
    case JavaCompiler => "System.out.print(arg0);"
    case ScalaCompiler => "print(arg0);"
  }
}

case object JavaCompiler extends Compiler
case object ScalaCompiler extends Compiler