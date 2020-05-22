public class BigDecimalConverter extends TypeConverter {

public BigDecimalConverter() {
    super(BigDecimal.class);
}

@Override
public Object encode(Object value, MappedField optionalExtraInfo) {
    BigDecimal val = (BigDecimal) value;
    if (val == null)
        return null;
    return val.toPlainString();
}

@Override
public Object decode(Class targetClass, Object fromDBObject,
        MappedField optionalExtraInfo) {
    if (fromDBObject == null)
        return null;
    BigDecimal dec = new BigDecimal(fromDBObject.toString());
    return dec;
}

}