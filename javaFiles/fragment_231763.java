import eu.maydu.gwt.validation.client.i18n.ValidationMessages;
public class CustomValidationMessages extends ValidationMessages {
  @Override
  public String getPropertyName(String propertyName) {
    return propertyName;   // This just returns the property name instead of the error message
  }
}