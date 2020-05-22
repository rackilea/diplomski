public class SimpleSqlParser10 {
    public static void main(String args[]) throws JSQLParserException {
        String sql = "SELECT * FROM myTable, (select * from myTable2) as data1, (select b from myTable3) as data2";
        Select select = (Select)CCJSqlParserUtil.parse(sql);
        System.out.println(select.toString());


        System.out.println("Type 1: Visitor processing");
        select.getSelectBody().accept(new SelectVisitorAdapter(){
            @Override
            public void visit(PlainSelect plainSelect) {
                plainSelect.getFromItem().accept(fromVisitor);
                if (plainSelect.getJoins()!=null)
                   plainSelect.getJoins().forEach(join -> join.getRightItem().accept(fromVisitor));
            }
        });

        System.out.println("Type 2: simple method calls");
        processFromItem(((PlainSelect)select.getSelectBody()).getFromItem());
        if (((PlainSelect)select.getSelectBody()).getJoins()!=null)
            ((PlainSelect)select.getSelectBody()).getJoins().forEach(join -> processFromItem(join.getRightItem()));


        System.out.println("Type 3: hierarchically process all subselects");
        select.getSelectBody().accept(new SelectDeParser() {
            @Override
            public void visit(SubSelect subSelect) {
                System.out.println("  found subselect=" + subSelect.toString());
                super.visit(subSelect);             }
        });
    }

    private final static FromItemVisitorAdapter fromVisitor = new FromItemVisitorAdapter() {
        @Override
        public void visit(SubSelect subSelect) {
            System.out.println("subselect=" + subSelect);
        }

        @Override
        public void visit(Table table) {
            System.out.println("table=" + table);
        }
    } ;

    private static void processFromItem(FromItem fromItem) {
        System.out.println("fromItem=" + fromItem);
    }
}