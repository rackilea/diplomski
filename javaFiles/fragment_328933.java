List<String> hostsList
        = rddList.map(value -> {
                Thread.sleep(3_000);
                return InetAddress.getLocalHost().getHostAddress();
            })
            .distinct()
            .collect();

    System.out.println("-----> hostsList = " + hostsList);