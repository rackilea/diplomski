public static BigDecimal copyOf(BigDecimal value)
{
    if (value == null || value.getClass() == BigDecimal.class)
        return value;
    return new BigDecimal(value.unscaledValue(), value.scale());
}