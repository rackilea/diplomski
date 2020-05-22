File diskRoot = new File("\\\\.\\F:");
byte[] buffer = new byte[1024];
try (InpuStream stream = new FileInputStream(diskRoot)) {
    while(stream.read(buffer) != -1) {
        //do something with buffer
    }
} catch(IOException e) {
    //handle exception
}