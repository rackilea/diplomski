public class Stockmarket {
        // instance variables
        private GregorianCalendar date;
        private double opening;
        private double closing;

        public Stockmarket(String dt, double opening, double closing) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
            Date d = null;
            try {
                d = sdf.parse(dt);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
            cal.setTime(d);
            this.date = cal;
            this.opening = opening;
            this.closing = closing;
        }

        public String date() {
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
            df.setCalendar(this.date);
            String date = df.format(this.date.getTime());
            return date;
        }
    }