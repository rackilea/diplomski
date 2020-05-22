private Collection<InetAddress> findLANMachines() throws IOException {
        String ip = "192.168.1."; //change that to whatever u want :- )
        ArrayList<InetAddress> lanMachines = new ArrayList<>();
        for (int i = 1; i <= 255; i++) {
            InetAddress a = InetAddress.getByName(ip+i);
            if(a.isReachable(2000)) //Change the timeout miliseconds to whatever u want, This may vary depending on the type of network you are on
                                    //and the capabilities of your card.
            lanMachines.add(a);
        }
        return lanMachines;
    }