// Get months
int months = Months.monthsBetween(begin, end).getMonths();
// Subtract this number of months from the end date so we can calculate days
DateTime newEnd = end.minusMonths(months);
// Get days
int days = Days.daysBetween(begin, newEnd).getDays();