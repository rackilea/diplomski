try {
sum = sum + Float.valueOf(latValues[i].trim()).floatValue();
}
catch (NumberFormatException e)
{
// log e if you want...
}