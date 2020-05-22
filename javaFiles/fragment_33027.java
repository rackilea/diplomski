private static final Utils.PID[] PIDS = Utils.PID.values();

private double[] findAllData(ByteBuffer message) {

    byte[] byteBuffer = new byte[9000];
    // parse through and find all PIDs
    for (int i = 0; i < message.capacity(); i++) {
        message.position(i);

        switch (PIDS[message.get(i)]) {
            case A:
                break;
            case B:
                break;
            case C:
                break;
        }
    }