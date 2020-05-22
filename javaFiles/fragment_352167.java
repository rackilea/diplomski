enum UnitValue
{
    UNIT1(defined1), UNIT2(defined2);

    final Number value;

    private UnitValue(Number value)
    {
        this.value = value;
    }
}

Number factor(String unitName)
{
    return Enum.valueOf(UnitValue.class, "UNIT" + Integer.parseInt(unitName.substring(5)).value;
}