Option groupOption = Option.builder("g")
            .longOpt("group")
            .required(false)
            .desc("The group of the user.")
            .hasArg() // This option has an argument.
            .build();