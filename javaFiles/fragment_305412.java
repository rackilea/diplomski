String[] subnetsMasks = { ... };
    Collection<SubnetInfo> subnets = new ArrayList<SubnetInfo>();
    for (String subnetMask : subnetsMasks) {
        subnets.add(new SubnetUtils(subnetMask).getInfo());
    }

    String ipAddress = ...;
    for (SubnetInfo subnet : subnets) {
        if (subnet.isInRange(ipAddress)) {
            System.out.println("IP Address " + ipAddress + " is in range " + subnet.getCidrSignature());
        }
    }