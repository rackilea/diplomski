public static LicenceNumber getInstance(Name driverName, Date issueDate){
  Calendar tempCal = Calendar.getInstance();
  tempCal.setTime(issueDate);
  String issueYear = String.valueOf(tempCal.get(Calendar.YEAR));

  // ** get the initials; I would actually move this functionality to be
  //   a method on the Name class
  String initials = driverName.getForename().substring(0, 1) + driverName.getSurname().substring(0, 1);

  // get the unique serial number
  String serial = getSequence(initials, issueYear);

  // make the full licenseplate String
  String k = makePrefix(initials, issueYear) + "-" + serial;

if(!LICENCENOS.containsKey(k)){
    LICENCENOS.put(k, new LicenceNumber(driverName,issueDate));
}

return LICENCENOS.get(k);