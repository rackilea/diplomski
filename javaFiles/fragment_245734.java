val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
  sourceGenerators in Compile <+= sourceManaged in Compile map { dir =>
    //example for one scala file, call your thrift generation here for multiple files
    val file = dir / "demo" / "Test.scala"
    IO.write(file, """object Test extends App { println("Hi") }""")

    Seq(file) //list your generated files here
   }
)