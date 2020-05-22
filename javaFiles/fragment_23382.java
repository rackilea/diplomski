String ipAddress  = "12.16.2.1";
String internalIPs = 
"166\\.41\\.8\\.X" + "|" +"12\\.16\\.X\\.X" + "|" +
"12\\.22\\.X\\.X" + "|" +"132\\.23\\.X\\.X" + "|";

Pattern p = Pattern.compile("^(?:"+internalIPs.replaceAll("X",
                            "(?:\\\\d{1,2}|1\\\\d{2}|2[0-4]\\\\d|25[0-5])")+")$");

//System.out.println(p.pattern());

Matcher m = p.matcher(ipAddress);
if (m.matches())
    System.out.println("print internal IP"); // gets printed  
else
    System.out.println("print external IP");