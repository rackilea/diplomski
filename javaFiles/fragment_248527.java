public class JdbcTest {

   List<Item> tempStockList = new ArrayList<>();

   @Before
   public void setup() {

    tempStockList = new ArrayList<>();
    tempStockList.add(new Item(1, "LEDTv", new BigInteger("40"),
            new Integer("3"), new BigInteger("70")));

   }


   @Test
   public void checkStockItemsName() throws Exception {
     JdbcItemDao jdbcItemDao = new CustomJdbcItemDao();
     assertTrue(jdbcItemDao.checkStockItems("LEDTv"));

   }

   private class CustomJdbcItemDao extends JdbcItemDao{

      @Override
      public List<Item> getAllStockItems(){
        return tempStockList;
      }
   }

}