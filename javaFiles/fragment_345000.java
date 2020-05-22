public class Test {

    public static void main(String[] args) throws ParseException {
        DF df = new DF("M/d/yy h:mm a z");
        String [][] zs = df.getDateFormatSymbols().getZoneStrings();
        for( String [] z : zs ) {
            System.out.println( Arrays.toString( z ) );
        }
    }

    private static class DF extends SimpleDateFormat {
        @Override
        public DateFormatSymbols getDateFormatSymbols() {
            return super.getDateFormatSymbols();
        }

        public DF(String pattern) {
            super(pattern);
        }
    }

}