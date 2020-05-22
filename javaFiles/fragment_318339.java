StringBuilder scmd = new StringBuilder (128);
  scmd.append ("SELECT HOST, PORT, VIRTUAL_HOST, CLUSTER ");
  scmd.append ("FROM PQR ");
  scmd.append ("WHERE TYPE='abc' ");
  if (names.length > 0) {
    scmd.append ("AND NAME IN (");
    for (int i = 0; i < names.length; i++) {
      if (i > 0)
        scmd.append (',');
      scmd.append ('?');
    }
    scmd.append (")");
  }
  PreparedStatement stmt = connection.prepareStatement(scmd.toString());