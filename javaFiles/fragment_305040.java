trait Compiler[C] {
  def printInstruction(c: C): String
}

case object JavaCompiler

implicit object JavaCompilerIsCompiler extends Compiler[JavaCompiler.type] {
  def printInstruction(c: JavaCompiler.type): String = "System.out.print(arg0);"
}

case object ScalaCompiler

implicit object ScalaCompilerIsCompiler extends Compiler[ScalaCompiler.type] {
  def printInstruction(c: ScalaCompiler.type) = "print(arg0);"
}