while (!pdsxOutRecords.isEmpty()) {
  PdsxRecord record = pdsxOutRecords.remove(0);
  if(record.getAttrs().containsKey(new PdsxAttrKey("SiteId"))) {
    System.out.println("Testing");
  }
}