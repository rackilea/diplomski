MockClasswriter("""
    |
    |package com.test
    |
    |class Example : Consumer<String> {
    |  override fun accept(value: String) {
    |    println("found: '$\value'")
    |  }
    |}
    """.trimMargin("|"))
    .writeToFile(codegenOutputFile)