String loc = con.getHeaderField("Location");
  byte [] locbytes = new byte[loc.length()];
  for (int index = 0; index < locbytes.length; index++)
  {
     locbytes[index] = (byte) loc.charAt(index);
  }

  // use this loc instead
  String loc2 = new String(locbytes, "UTF-8");