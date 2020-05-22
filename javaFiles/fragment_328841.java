public class MyReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

    public MyReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }

    @Override
    public boolean excludeForeignKeyAsManytoOne(String keyname, TableIdentifier fromTable, List fromColumns, TableIdentifier referencedTable, List referencedColumns) {
        return true;
                }

}