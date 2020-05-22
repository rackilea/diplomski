public class Test {  
    public static void main(String[] args){
        String name = DatabaseTableConfig.extractTableName(A.class);
        System.out.println(name); //TableA
    }
}
@DatabaseTable(tableName="TableA")
class A {}