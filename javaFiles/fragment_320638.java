String createUniqDir() {
   // Use SimpleDateFormat or just millis from Date 
   // We just trying to be as uniq as possible.
  String timeStampStr;
  Date now = new Date();
  timeStampStr = "" + now.getTime(); // If using EPOC
  // This soln if you wana use SimpleDateFormat
  // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
  // timeStampStr = sdf.format(dt);
  int counter = 1;

  String dirToCreateStr = "some_prefix-" + timeStampStr;
  File dirToCreate = new File(dirToCreate);

  while(!dirToCreate.mkdir()) {
    dirToCreateStr = "some_prefix-" + timeStampStr + "-" + counter;
    file = new File(dirToCreate);
    counter++;
  }
  return dirToCreateStr;
}