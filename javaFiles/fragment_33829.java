public class Test {

    public Test() {

    }

    public SQLarguments arguments(String table, String... columns) {
        SQLarguments testArgs = new SQLarguments(table, columns);
        return testArgs;
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        SQLarguments arguments = 
                t1.arguments("table","col 1","col 2", "col 3");
        System.out.println(arguments.getColumns()[0]);
        System.out.println("test");
    }   //end main

    public class SQLarguments {     // Embedded class
        String[]    columns;
        String      table;

        public SQLarguments(String table, String... columns) {
            this.table = table;
            this.columns = columns;
        }

        public String[] getColumns() {
            return columns;
        }

        public String getTable() {
            return table;
        }

    }

}