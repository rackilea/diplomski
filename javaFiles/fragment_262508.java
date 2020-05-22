import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public enum DayOfTheWeek {
    SUNDAY {
        @Override
        public int toCalendar() {
            return Calendar.SUNDAY;
        }

    },
    MONDAY {
        @Override
        public int toCalendar() {
            return Calendar.MONDAY;
        }
    },
    TUESDAY {
        @Override
        public int toCalendar() {
            return Calendar.TUESDAY;
        }
    },
    WEDNESDAY {
        @Override
        public int toCalendar() {
            return Calendar.WEDNESDAY;
        }
    },
    THURSDAY {
        @Override
        public int toCalendar() {
            return Calendar.THURSDAY;
        }
    },
    FRIDAY {
        @Override
        public int toCalendar() {
            return Calendar.FRIDAY;
        }
    },
    SATURDAY {
        @Override
        public int toCalendar() {
            return Calendar.SATURDAY;
        }
    };

    public abstract int toCalendar();

    public static DayOfTheWeek fromCalendarDay(int day) {

        for (DayOfTheWeek dayOfWeek : DayOfTheWeek.values()) {
            if (dayOfWeek.toCalendar() == day) {
                return dayOfWeek;
            }
        }

        return null; // Consider throwing IllegalArgumentException
    }

    public static DayOfTheWeek getByDate(Date date) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        return fromCalendarDay(calendar.get(Calendar.DAY_OF_WEEK));
    }

    @Override
    /*
     * Should return the localized day of the week
     */
    public String toString() {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.DAY_OF_WEEK, this.toCalendar());
        SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat
                .getInstance();
        sdf.applyPattern("EEEEEEEEEE");

        return sdf.format(c.getTime());
    }

}