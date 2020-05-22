public void testSpringMultiValueMap() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("dc1Server", "dc1HostA,dc1IPAddressA");
        map.add("dc1Server", "dc1HostB,dc1IPAddressB");
        map.add("dc1Server", "dc1HostC,dc1IPAddressC");
        map.add("dc2Server", "dc2HostA,dc2IPAddressA");
        map.add("dc2Server", "dc2HostB,dc2IPAddressB");
        map.add("dc2Server", "dc2HostC,dc2IPAddressC");

        List<String> dc1List = map.get("dc1Server");

        for(String pair: dc1List) {
            String[] tokens = pair.split(",");
            System.out.println("host: " + tokens[0] + " ip: " + tokens[1]);
        }
    }