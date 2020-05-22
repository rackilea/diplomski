/* as static field of class */
private static final AtomicBoolean ONE_ON_WORKER = new AtomicBoolean(false);

...

    long nodeCount
        = rddList.map(value -> {
                Thread.sleep(3_000);
                if (ONE_ON_WORKER.getAndSet(true) == false) {
                    System.out.println("Executed on "
                            + InetAddress.getLocalHost().getHostName());
                    return 1;
                } else {
                    return 0;
                }
            })
            .filter(val -> val != 0)
            .count();

    System.out.println("-----> finished using #nodes = " + nodeCount);