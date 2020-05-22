object Main {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val stream = env.fromCollection(1 to 4)

    val prop = System.getProperty("dy.props.path")
    stream.map(_ => System.getProperty("dy.props.path") + "  mainArg: " + prop).print()

    env.execute("stream")
  }
}