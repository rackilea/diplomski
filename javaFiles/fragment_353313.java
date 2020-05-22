val cmd: CommandLine = try {
        parser.parse("options", "args")
    } catch (ex: Exception) {
        // Must:
        // 1) Throw, or error in some other way so as to return Nothing.
        // 2) Return a default/failed value for cmd. Maybe something like EmptyCommandLine or FailedCommandLine(ex)
        // 3) Make cmd nullable and return null.

        CommandLine() // or, error("Unable to parse options!")
    }

    val inputArg = cmd.getOptionValue("someArg")
}