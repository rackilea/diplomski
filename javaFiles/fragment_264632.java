void getInteger(OutValue<Integer> x)
{
    x.value = 1;
}

OutValue<Integer> outValue = OutValue.makeOutValue(0);
getInteger(outValue);
System.out.println("value = " + outValue.value);