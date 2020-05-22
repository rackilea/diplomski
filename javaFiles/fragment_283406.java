@Converter(autoApply = true)
public class YearMonthConverter implements AttributeConverter<YearMonth, Date> {

  @Override
  public Date convertToDatabaseColumn(YearMonth attribute) {
    // uses default zone since in the end only dates are needed
    return attribute == null ? null : Date.from(attribute.atDay(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
  }

  @Override
  public YearMonth convertToEntityAttribute(Date dbData) {
    // TODO: check if Date -> YearMonth can't be done in a better way
    if (dbData == null) return null;
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dbData);
    return YearMonth.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
  }
}