You can use this custom annotation above your class.

    @ValidateIfAnotherFieldHasValue(
            fieldName = "userType",
            fieldValue = "2",
            dependFieldName = "property2")
  public class ComplexUserForm {
       int userType;

       @Valid
       UserPropertyForm property1;
       UserPropertyForm property2;