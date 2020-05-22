public class GenericOpService implements GenericOpServiceMBean {
    public String op(List<Date> dates) {
        if(dates==null || dates.isEmpty()) return "";
        StringBuilder b = new StringBuilder();
        for(Date d: dates) {
            b.append("\n\t").append(d);
        }
        return b.toString();
    }
}