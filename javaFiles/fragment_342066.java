public class Formatter implements ConfigurableCustomConverter
{
   private String format;
   private String[] fields;

   @Override
   public Object convert(Object existingDestinationFieldValue, Object           sourceFieldValue, Class<?> destinationClass, Class<?> sourceClass) {
      List valueList = new ArrayList();

      for (String field : fields){
        try {
           valueList.add(sourceClass.getMethod(field).invoke(sourceFieldValue));
        }
        catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
           throw new RuntimeException("Reflection error during mapping", e);
        }
     }
     return MessageFormat.format(format, valueList.toArray());
  }

  @Override
  public void setParameter(String parameter)
  {
     String[] parameters = parameter.split("\\|");
     format = parameters[0];
     fields = Arrays.copyOfRange( parameters, 1, parameters.length);
  }
}