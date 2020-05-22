sealed trait RunResult extends Product with Serializable
case object Run extends RunResult
case object Debug extends RunResult

def run(args: List[String]): IO[ExitCode] = {
  run0(args) >> IO.pure(ExitCode.Success)
}

def run0(args: List[String]): IO[RunResult] = {
  for {
    _ <- IO { println("Running with args: " + args.mkString(",")) }
    debug = args.contains("debug")
    runResult <- if (debug) debugLoop else IO.pure(Run)
  } yield runResult
}

def debugLoop: IO[Debug.type] =
  for {
    _ <- IO(println("Debug mode: exit application be pressing ENTER."))
    _ <- IO.shift(BlockingFileIO) // readLine might block for a long time so we shift to another thread
    input <- IO(StdIn.readLine()) // let it run until user presses return
    _ <- IO.shift(ExecutionContext.global) // shift back to main thread
    _ <- if (input == "b") {
      // do some debug relevant stuff
      IO(Unit) >> debugLoop
    } else {
      shutDown()
    }
  } yield Debug

  // shuts down everything
  def shutDown(): IO[Unit] = ???
}