@RequestMapping(value = "test", method = RequestMethod.GET)
    public HashMap<String, String> testRequest(@RequestParam String[] numservers, @RequestParam String[] ipaddress, @RequestParam String[] hostname) {
    //By using array position you can determine each row
    //DC1 values
    String dc1_numServer = numservers[0];
    String dc1_ipaddres= ipaddress[0];
    String dc1_hostname= hostname[0];
    //DC2 values
    String dc2_numServer = numservers[1];
    String dc2_ipaddres= ipaddress[1];
    String dc2_hostname= hostname[1];
    //DC3 values
    String dc3_numServer = numservers[2];
    String dc3_ipaddres= ipaddress[2];
    String dc3_hostname= hostname[2];
    }