public class MyOfficeCalendar extends GregorianCalendar{

    public static class Builder {

        private Integer rawOffset;


        public void setRawOffset(int rawOffset) {
            this.rawOffset = rawOffset;
        }

        public MyOfficeCalendar build(){
            TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");

            int effectiveRawOffset = tz.getRawOffset();
            if(rawOffset != null){
                effectiveRawOffset = rawOffset;
            }
            SimpleTimeZone simpleTimeZone = new SimpleTimeZone(effectiveRawOffset, tz.getID());
            return new MyOfficeCalendar(simpleTimeZone);
        }
    }

   private MyOfficeCalendar(SimpleTimeZone simpleTimeZone){
        super(simpleTimeZone);
   }
 }