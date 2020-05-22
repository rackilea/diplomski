@Override
public String getSwaggerType(final Property property)
{
  if ((property instanceof StringProperty) && ("time".equals(property.getFormat())))
  {
    return "OffsetTime";
  }
  else
  {
    return super.getSwaggerType(property);
  }
}