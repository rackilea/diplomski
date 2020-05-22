import java.lang.reflect.Field;

public class TestAnnotations {

   @Test_Target(doTestTarget="Hello World !")
   private String str;

   public static void main(String[] args) throws Exception {
      // We need to use getDeclaredField here since the field is private.
      Field field = TestAnnotations.class.getDeclaredField("str");
      Test_Target ann = field.getAnnotation(Test_Target.class);
      if (ann != null) {
         System.out.println(ann.doTestTarget());
      }
   }
}