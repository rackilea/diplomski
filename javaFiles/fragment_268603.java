@Override
public boolean isValid(Address address, ConstraintValidatorContext constraintContext)
{
    String postalCode = address.getPostalCode();
    String country = address.getCountry();
    String regex = null;
    if (null == country || Address.COUNTRY_USA.equals(country))
    {
        regex = "^[0-9]{5}$";
    }
    else if (Address.COUNTRY_CANADA.equals(country))
    {
      regex = "^[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]$";
    }

  Pattern postalPattern = Pattern.compile(regex);
  Matcher matcher = postalPattern.matcher(postalCode);
  if (matcher.matches())
  {
    return true;
  }

  // this will generate a field error for "postalCode" field.
  constraintContext.disableDefaultConstraintViolation();
  constraintContext.buildConstraintViolationWithTemplate("custom_error_code").addNode("postalCode").addConstraintViolation();

    return false;
}