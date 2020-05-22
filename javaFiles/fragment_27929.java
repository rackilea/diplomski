@Override
public void processOpts()
{
  super.processOpts();
  typeMapping.put("DateTime", "Instant");
  typeMapping.put("date", "LocalDate");
  typeMapping.put("time", "OffsetTime");

  importMapping.put("Instant", "java.time.Instant");
  importMapping.put("LocalDate", "java.time.LocalDate");
  importMapping.put("OffsetTime", "java.time.OffsetTime");
  ...