public class Filter {

     List<FieldFilter> filters;

     public static class FieldFilter {
         private String field;
         private String value;
     }
}