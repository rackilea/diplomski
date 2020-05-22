public class RFC3339Converter extends StrutsTypeConverter{

    @Override
    public String convertToString(Map context, Object o) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(o);
    }

    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         try {
             return (values[0].length()==0) ? null : (Date) sdf.parse(values[0]);
         } catch (ParseException e) {
             return values[0];
         }
    }
}