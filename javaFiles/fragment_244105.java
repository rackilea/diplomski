public final class Date {
        final int year;
        final int month;
        final int day;

        public static Date parse(String dateAsString) {
            String[] strSplit = dateAsString.split("/");
            int m = Integer.parseInt(strSplit[0]);
            int d = Integer.parseInt(strSplit[1]);
            int y = Integer.parseInt(strSplit[2]);
            return new Date(y, m, d);
        }

        public Date(int year, int month, int day) {
            checkValues(year, month, day);
            this.year = year;
            this.month = month;
            this.day = day;
        }

        private static void checkValues(int year, int month, int day) {
            if (!isValidDate(year, month, day))
                throw new IllegalArgumentException("Invalid date values.");
        }

        private static boolean isValidDate(int year, int month, int day) {
            // TODO Validation!
            return true;
        }
    }