ChineseCalendar obj = PlainDate.nowInSystemTime().transform(ChineseCalendar.axis());

    ChronoFormatter<ChineseCalendar> f =
        ChronoFormatter.ofPattern(
          "d/M/U(r)", 
          PatternType.CLDR, 
          Locale.ROOT, 
          ChineseCalendar.axis());

    System.out.println(f.print(obj));   
    // output today: 1/9/ji-hai(2019)