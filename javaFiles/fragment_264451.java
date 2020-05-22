public class QueryParser {

    public static int flag = 0;

    void getAggregateFunctions(String queryString) {

        if (queryString.contains("count") || queryString.contains("sum") || queryString.contains("min")
                || queryString.contains("max") || queryString.contains("avg")) {
            flag = flag + 1;
        }
    }

    void getGroupByFields(String queryString) {

        if (queryString.contains("group by")) {
            flag = flag+2;
        }
    }

    public static void main(String[] args) {

        QueryParser q = new QueryParser();
        System.out.println(flag); //prints out 0
        q.getAggregateFunctions("max"); System.out.println(flag); //prints out 1
        q.getAggregateFunctions("aString"); System.out.println(flag); //prints out 1
        q.getAggregateFunctions("avgNumber"); System.out.println(flag); //prints out 2
        q.getGroupByFields("group by"); System.out.println(flag); //prints out 4
    }
}