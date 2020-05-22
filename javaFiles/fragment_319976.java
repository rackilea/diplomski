public List<Log> getCountryAndAccess(String cc, AccessType access) {
  List<Log> sublist = new ArrayList<Log>();
  for (Log log : logList) 
    if (cc.equals(log.getCountryCode()) && (log.getAccessType() == access))
      sublist.add(log);
  return sublist;
}