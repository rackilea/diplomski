PeriodFormatter formatter = new PeriodFormatterBuilder()
        .printZeroAlways()
        .minimumPrintedDigits(2)
        .appendHours()
        .appendLiteral(":")
        .appendMinutes()
        .appendLiteral(":")
        .appendSeconds()
        .toFormatter();