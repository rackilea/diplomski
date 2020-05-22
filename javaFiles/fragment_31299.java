import com.mariadb.columnstore.api.*;

public class MCSAPITest {

        public static void main(String[] args) {
        ColumnStoreDriver d = new ColumnStoreDriver();
        for(int i=0; i<Integer.MAX_VALUE; i++){
            ColumnStoreBulkInsert b = d.createBulkInsert("test", "garbage_test", (short)0, 0);
            try{
                b.setColumn(0, i);
                b.setColumn(1, Integer.MAX_VALUE-i);
                b.writeRow();
                b.commit();
            } catch(ColumnStoreException e){
                b.rollback();
                e.printStackTrace();
            } finally{
              b.delete(); //<--This is the important part
            }
        }
    }
}