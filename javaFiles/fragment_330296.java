DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    DateTimeFormatter dowFormatter 
            = DateTimeFormatter.ofPattern("EEEE", Locale.getDefault(Locale.Category.FORMAT));
    DayOfWeek dow = DayOfWeek.from(dowFormatter.parse(day));

    WeekFields wf = WeekFields.of(Locale.getDefault(Locale.Category.DISPLAY));

    LocalDate date = LocalDate.of(year, month, 15)
            .with(dow)
            .with(wf.weekOfMonth(), week);
    System.out.println("Result: " + date.format(dateFormatter));