public class Holidays {

        private final Calendar calendar = Calendar.getInstance();
        private final String holidayName;

        public Holidays(String holidayName, Date date) {
            this.holidayName = holidayName;
            this.calendar.setTime(date);
        }

        @Override
        public int compareTo(Holidays another) {
            // Generally you should avoid passing information statically between Activities
            if(MainActivity.sortByName == true) {
                    return holidayName.compareToIgnoreCase(another.holidayName);
            }
            return getTimeInMillis() - another.getTimeInMillis();
        }

        public long getTimeInMillis() {
            return this.calendar.getTimeInMillis();
        }

        @Override
        public String toString() {
        //DayOfWeek is just an enum of days (strings)
            DayOfWeek day = DayOfWeek.values()[calendar.get(Calendar.DAY_OF_WEEK)]; // Now you won't get the same day every time. :)
            return String.format("%s falls of %s", this.holidayName, day);
        }

    }