public static boolean validateTwoFields(
Object bean,
ValidatorAction va, 
Field field,
ActionErrors errors,
HttpServletRequest request, 
ServletContext application) {

String value = ValidatorUtils.getValueAsString(
    bean, 
    field.getProperty());
String sProperty2 = field.getVarValue("secondProperty");
String value2 = ValidatorUtils.getValueAsString(
    bean, 
    sProperty2);

if (!GenericValidator.isBlankOrNull(value)) {
   try {
      if (!value.equals(value2)) {
         errors.add(field.getKey(),
            Resources.getActionError(
                application,
                request,
                va,
                field));

         return false;
      }
   } catch (Exception e) {
         errors.add(field.getKey(),
            Resources.getActionError(
                application,
                request,
                va,
                field));
         return false;
   }
}

return true;}