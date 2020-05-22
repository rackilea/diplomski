SystemUnderTest recursiveInstance = this; // replace with a mock within test

public Object getColumnValue(ReportRow row, String columnId, Vector errors) {
  if (HSBC_PAYREC.equals(columnId)) {
    String s = (String) recursiveInstance.getColumnValue(row, "Pay/Rcv", errors);
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