package io.fouad.utils;

import java.time.DayOfWeek;
import java.util.Locale;
import java.util.spi.CalendarDataProvider;

public class ArabicCalendarDataProvider extends CalendarDataProvider
{
    private static final DayOfWeek FIRST_DAY_OF_WEEK = DayOfWeek.SUNDAY;

    @Override
    public int getFirstDayOfWeek(Locale locale)
    {
        return (FIRST_DAY_OF_WEEK.getValue() + 1) % 7;
    }

    @Override
    public int getMinimalDaysInFirstWeek(Locale locale)
    {
        return 1;
    }

    @Override
    public Locale[] getAvailableLocales()
    {
        return new Locale[]{new Locale("ar", "SA")};
    }

    @Override
    public boolean isSupportedLocale(Locale locale)
    {
        return locale != null && "ar".equals(locale.getLanguage()) && "SA".equals(locale.getCountry());
    }
}