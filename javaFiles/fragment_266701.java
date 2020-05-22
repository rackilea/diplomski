public class TimeAgo {
    public static final List<Long> times = Arrays.asList(
            TimeUnit.DAYS.toMillis(365),
            TimeUnit.DAYS.toMillis(30),
            TimeUnit.DAYS.toMillis(1),
            TimeUnit.HOURS.toMillis(1),
            TimeUnit.MINUTES.toMillis(1),
            TimeUnit.SECONDS.toMillis(1) );
    public static final List<String> timesString = Arrays.asList("year","month","day","hour","minute","second");

    public static String toDuration(long duration) {

        StringBuffer res = new StringBuffer();
        for(int i=0;i< Lists.times.size(); i++) {
            Long current = Lists.times.get(i);
            long temp = duration/current;
            if(temp>0) {
                res.append(temp).append(" ").append( Lists.timesString.get(i) ).append(temp > 1 ? "s" : "").append(" ago");
                break;
            }
        }
        if("".equals(res.toString()))
            return "0 second ago";
        else
            return res.toString();
    }
    public static void main(String args[]) {
        System.out.println(toDuration(123));
        System.out.println(toDuration(1230));
        System.out.println(toDuration(12300));
        System.out.println(toDuration(123000));
        System.out.println(toDuration(1230000));
        System.out.println(toDuration(12300000));
        System.out.println(toDuration(123000000));
        System.out.println(toDuration(1230000000));
        System.out.println(toDuration(12300000000L));
        System.out.println(toDuration(123000000000L));
    }}