public DALWrapper implements DALInterface
{
   private ProdDAL dal;

   public DALWrapper(ProdDAL prodDAL)
   {
      this.dal = prodDal;
   }

... rest of interface goes here
}