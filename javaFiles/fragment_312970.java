public static String toHumanFormat(int totalDays){
    int years = totalDays / 356;
    int months = (totalDays % 356) / 30;
    int days = totalDays % 356 % 30;
    return MessageFormat.format("{0,choice,0#|1#1 year|1<{0} years} " +
            "{1,choice,0#|1#1 month|1<{1} months} " +
            "{2,choice,0#|1#1 day|1<{2} days}",
            years, months, days).trim();
  }