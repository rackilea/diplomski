object JvmCompile {

  fun exe(input: File, output: File): Boolean = K2JVMCompiler().run {
    val args = K2JVMCompilerArguments().apply {
      freeArgs = listOf(input.absolutePath)
      loadBuiltInsFromDependencies = true
      destination = output.absolutePath
      classpath = System.getProperty("java.class.path")
          .split(System.getProperty("path.separator"))
          .filter {
            it.asFile().exists() && it.asFile().canRead()
          }.joinToString(":")
      noStdlib = true
      noReflect = true
      skipRuntimeVersionCheck = true
      reportPerf = true
    }
    output.deleteOnExit()
    execImpl(
        PrintingMessageCollector(
            System.out,
            MessageRenderer.WITHOUT_PATHS, true),
        Services.EMPTY,
        args)
  }.code == 0

}