DateTimeFormatter patternWithOptional = new DateTimeFormatterBuilder()
            .appendPattern("M/d/yyyy[ H:mm]")
            .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
            .toFormatter();
    System.out.println(LocalDateTime.parse("4/11/2020 1:20", patternWithOptional));
    System.out.println(LocalDateTime.parse("4/11/2020", patternWithOptional));