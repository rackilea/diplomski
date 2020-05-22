private Collection<InetAddress> findLANMachines() throws IOException {
        int depth = 1; //This number is the range from 1 to X representing * in this ip: 192.168.*.1
        int subDepth = 255; //This is the range from 1 to X representing * in this ip: 192.168.1.*
        int TIMEOUT = 1000;//The ammount to which we need to wait for the other host to reply before we skip to the next one (in ms)
        String ip = InetAddress.getLocalHost().toString().split("/")[1];
        String tmp = ip.substring(0,
                ip.lastIndexOf(".", ip.lastIndexOf(".") - 1))
                + ".";
        ArrayList<InetAddress> lanMachines = new ArrayList<>();
        for (int j = 1; j < depth; j++) {
            for (int i = 1; i < subDepth; i++) {
                InetAddress a = InetAddress.getByName(tmp + j + "." + i);
                if (a.isReachable(TIMEOUT))
                    lanMachines.add(a);
            }
        }
        return lanMachines;
    }