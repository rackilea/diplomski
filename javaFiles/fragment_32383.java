public class XYZ {

   private TestUrl[] testUrlArray;

   public XYZ(){

      testUrlArray = new TestUrl[2];
      testUrlArray[0] = new TestUrl("ID_1");
      testUrlArray[1] = new TestUrl("ID_2");
   }

   public TestUrl getTestUrl(int i){

      return testUrlArray[i];
   }
}