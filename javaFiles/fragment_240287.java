String SNMPMSG  = "my snmpMsg now";
  String[] commandAndArgs = new String[]{
          "./snmptrap.pl",
          "-h",
          "myhost", 
          SNMPMSG
  };
  Process p = Runtime.getRuntime().exec(commandAndArgs);