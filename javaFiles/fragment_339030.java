LocalTime.parse(
    "12:05am", 
     new DateTimeFormatterBuilder().
         parseCaseInsensitive().
         appendPatt‌​‌​ern("hh:mma").
         toFo‌​rm‌​atter(Locale.US)‌​);