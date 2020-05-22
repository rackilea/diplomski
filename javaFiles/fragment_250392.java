public class JodaDateConverter extends AbstractSingleValueConverter {



 @Override
  @SuppressWarnings("unchecked")
  public boolean canConvert(final Class type) {
          return (type != null) && LocalDate.class.getPackage().equals(type.getPackage());
  }

  @Override
  public Object fromString(String str) {
    String separator;
    if(str.contains(":")){
      separator = ":";
    } else if(str.contains("/")){
      separator = "/";
    } else if(str.contains("-")){
      separator = "-";
    } else {
      throw new RuntimeException("The date must contains ':' or '/' or '-'");
    }
    String[] date = str.split(separator);
    if(date.length < 3){
      throw new RuntimeException("The date must contains hour, minute and second");
    }
    return new LocalDate(Integer.valueOf(date[0]),Integer.valueOf(date[1]),Integer.valueOf(date[2]));
  }

}