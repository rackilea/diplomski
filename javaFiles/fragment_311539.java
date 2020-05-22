int MONDAY = 1, TUESDAY = 2, WEDNESDAY = 3, THURSDAY = 4, FRIDAY = 5;
int today = getToday();
int weeks = weekdays / 5;
int extraDays = weekdays % 5;
int days = weeks * 7;
if (today <= extraDays) {
    days += 2;
}
days += extraDays;