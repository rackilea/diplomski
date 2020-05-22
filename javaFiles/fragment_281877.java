public class DALFactory
{
   private static DALInterface DAL;

   public static void setDAL(DALInterface di)
   {
      DAL = di;
   }

   public static void init(String fqcn)
   {
      // use reflect to create unit test instance
   }

   public static DALInterface getDAL()
   {
      return DAL;
   }
}