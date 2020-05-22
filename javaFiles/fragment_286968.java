LOG.info("Reading stream.");
while( (controlFileEntry = controlFileReader.readLine()) != null)
{
  // Every iteration should start with the ORIGINAL_DATE_FORMAT
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ORIGINAL_DATE_FORMAT);
  simpleDateFormat.setLenient(false);