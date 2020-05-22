ByteBuffer bb = ByteBuffer.allocate(65535); // 65535 is for example, In your code ByteBuffer need to be return by ReadConfigFile.importConfigFile();


    List<Device> devices = new ArrayList<Device>();


    byte[] unused = new byte[128];
    bb.get(unused); // this will return the 128 first bytes. ByteBuffer
                    // position is 129
    while (bb.hasRemaining()) {  // Make a check to Verify that bb have at least 8 bytes, if not, last code can be corrupted  => if you need it
        byte[] code = new byte[8]; // 8 byte for 1 code
        bb.get(code); // now code in set with the 8 next bytes 129-136 ;
        Device device = new Device(code); // set Directly the code with the constructor
        devices.add(device);
    }