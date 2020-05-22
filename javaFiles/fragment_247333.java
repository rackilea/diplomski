public class Wrapper implements MyWrapper{

   public Object invokeThirdPartyFunction(File file){
      new ThirdPartyCode().actualMethod(file);
   }
}