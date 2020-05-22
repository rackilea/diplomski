trait Compiler {
  def printInstruction: String
}

class JavaCompiler extends Compiler {
  def printInstruction = "System.out.print(arg0);"
}

class ScalaCompiler extends Compiler {
  def printInstruction = "print(arg0);"
}