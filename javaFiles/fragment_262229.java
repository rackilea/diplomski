// creating piped streams
private PipedInputStream pis;
private PipedOutputStream pos;
private DataOutputStream dos;
private DataInputStream dis;

...

pos = new PipedOutputStream();
pis = new PipedInputStream(pos);
dos = new DataOutputStream(pos);
dis = new DataInputStream(pis);

// in thread creating data dynamically
try {
    // writing data to dos stream
    ...
    dos.write(b);
    ...
} catch (IOException e) {
    // TODO
}

// Before finishing thread, we have to flush and close dos stream
// then dis stream will know that all data have been written and will finish
// streaming data to server.
try {
    dos.flush();
    dos.close();
} catch (Exception e) {
    // TODO
}