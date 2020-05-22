public static void injectCustomHijriVariant(Map<Integer, int[]> yearMonthsMap, long isoStartDate)
        throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException
{
    int minYear = Integer.MAX_VALUE;
    int maxYear = Integer.MIN_VALUE;

    for(int year : yearMonthsMap.keySet())
    {
        maxYear = Math.max(maxYear, year);
        minYear = Math.min(minYear, year);
    }

    int isoStart = (int) LocalDateTime.ofInstant(Instant.ofEpochMilli(isoStartDate),
                                                 ZoneId.systemDefault()).toLocalDate().toEpochDay();

    Field initCompleteField = HijrahChronology.class.getDeclaredField("initComplete");
    initCompleteField.setAccessible(true);
    initCompleteField.set(HijrahChronology.INSTANCE, true);

    Field hijrahStartEpochMonthField = HijrahChronology.class.getDeclaredField("hijrahStartEpochMonth");
    hijrahStartEpochMonthField.setAccessible(true);
    hijrahStartEpochMonthField.set(HijrahChronology.INSTANCE, minYear * 12);

    Field minEpochDayField = HijrahChronology.class.getDeclaredField("minEpochDay");
    minEpochDayField.setAccessible(true);
    minEpochDayField.set(HijrahChronology.INSTANCE, isoStart);

    Method createEpochMonthsMethod = HijrahChronology.class.getDeclaredMethod("createEpochMonths", int.class,
                                                                              int.class, int.class, Map.class);
    createEpochMonthsMethod.setAccessible(true);
    int[] hijrahEpochMonthStartDays = (int[]) createEpochMonthsMethod.invoke(HijrahChronology.INSTANCE, isoStart, minYear, maxYear, years);

    Field hijrahEpochMonthStartDaysField =
                                        HijrahChronology.class.getDeclaredField("hijrahEpochMonthStartDays");
    hijrahEpochMonthStartDaysField.setAccessible(true);
    hijrahEpochMonthStartDaysField.set(HijrahChronology.INSTANCE, hijrahEpochMonthStartDays);

    Field maxEpochDayField = HijrahChronology.class.getDeclaredField("maxEpochDay");
    maxEpochDayField.setAccessible(true);
    maxEpochDayField.set(HijrahChronology.INSTANCE, hijrahEpochMonthStartDays[hijrahEpochMonthStartDays.length - 1]);

    Method getYearLengthMethod = HijrahChronology.class.getDeclaredMethod("getYearLength", int.class);
    getYearLengthMethod.setAccessible(true);

    Field minYearLengthField = HijrahChronology.class.getDeclaredField("minYearLength");
    minYearLengthField.setAccessible(true);

    Field maxYearLengthField = HijrahChronology.class.getDeclaredField("maxYearLength");
    maxYearLengthField.setAccessible(true);

    for(int year = minYear; year < maxYear; year++)
    {
        int length = (int) getYearLengthMethod.invoke(HijrahChronology.INSTANCE, year);
        int minYearLength = (int) minYearLengthField.get(HijrahChronology.INSTANCE);
        int maxYearLength = (int) maxYearLengthField.get(HijrahChronology.INSTANCE);
        minYearLengthField.set(HijrahChronology.INSTANCE, Math.min(minYearLength, length));
        maxYearLengthField.set(HijrahChronology.INSTANCE, Math.max(maxYearLength, length));
    }
}