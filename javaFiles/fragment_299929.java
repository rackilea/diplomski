/**
 * @param dayOfWeek
 *            The day of week of the start day. The values are numbered
 *            following the ISO-8601 standard, from 1 (Monday) to 7
 *            (Sunday).
 * @param businessDays
 *            The number of business days to count from the day of week. A
 *            negative number will count days in the past.
 * 
 * @return The absolute (positive) number of days including weekends.
 */
public long getAllDays(int dayOfWeek, long businessDays) {
    long result = 0;
    if (businessDays != 0) {
        boolean isStartOnWorkday = dayOfWeek < 6;
        long absBusinessDays = Math.abs(businessDays);

        if (isStartOnWorkday) {
            // if negative businessDays: count backwards by shifting weekday
            int shiftedWorkday = businessDays > 0 ? dayOfWeek : 6 - dayOfWeek;
            result = absBusinessDays + (absBusinessDays + shiftedWorkday - 1) / 5 * 2;
        } else { // start on weekend
            // if negative businessDays: count backwards by shifting weekday
            int shiftedWeekend = businessDays > 0 ? dayOfWeek : 13 - dayOfWeek;
            result = absBusinessDays + (absBusinessDays - 1) / 5 * 2 + (7 - shiftedWeekend);
        }
    }
    return result;
}