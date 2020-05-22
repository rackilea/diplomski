@Named("test")
public class TestComponent {
   ...
   @Inject public void setA(@TestQualifier Object value) {
       String stringValue = (String) value;

   ...
   @Inject public void setB(@TestQualifier Object value) {
       int intValue = (Integer) value;