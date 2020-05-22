List<String> srcstr = new ArrayList<String>();
srcstr.add("New York");
srcstr.add("Atlanta");
srcstr.add("Dallas");
srcstr.add("Madison");

List<String> deststr = new ArrayList<String>();
deststr.add("Delhi");
deststr.add("Mumbai");

Collections.copy(srcstr, deststr);