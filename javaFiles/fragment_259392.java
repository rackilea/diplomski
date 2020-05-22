public Object getColumnValue(ReportRow row, String columnId, Vector errors) {
  if (HSBC_PAYREC.equals(columnId)) {
    String s = (String) getColumnValueRecursively(row, "Pay/Rcv", errors);
    if (s != null) {
      if (s.equals("Pay")) {
        return "Receive";
      }
      if (s.equals("Receive")) {
        return "Pay";
      }
      return "";
    }
  }
}

/** For testing. */
Object getColumnValueRecursively(ReportRow row, String columnId, Vector errors) {
  return getColumnValue(row, columnId, errors);
}