import scala.io.Source

  @Test def test2() = {
    try {
      val data_in = getClass().getClassLoader()
        .getResourceAsStream("com/myProject/myPackage/myInput.txt")

      for (line <- Source.fromInputStream(data_in).getLines()) {
          val data_out = MyTool.process(line)

          println(data_out)
      }

    } catch {
      case e: Exception =>

        println("process failed")
    }
  }