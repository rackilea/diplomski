long t0 = System.currentTimeMillis();

public void encode(byte[] data) {
    if (System.currentTimeMillis() - t0 >= 5000) {
        t0 = System.currentTimeMillis();
        // process the data and then send to RTMP server
    } else {
        // buffer data
    }
}