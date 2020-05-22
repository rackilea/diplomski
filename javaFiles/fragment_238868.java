public class ExcelReader<T> extends Reader<T> implements RowColumnReader<T> {

   private Class<T> genericType;

   public ExcelReader(Class<T> genericType){
       this.genericType = genericType;
   }
   /*...*/
}