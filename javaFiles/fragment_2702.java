@Entity
@Audited(withModifiedFlag = true)
public class SomeEntity {
   @Audited(modifiedColumnName = "CUSTOMER_NAME")
   private String customerName;
}