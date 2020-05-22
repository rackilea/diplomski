public class UtilClass {

    public static List<Device> createDevices(){

   List<Device> result =  new ArrayList<Device>();


    byte[] unused = new byte[128];
    bb.get(unused); // this will return the 128 first bytes. ByteBuffer
                    // position is 129
    while (bb.hasRemaining()) {
        byte[] code = new byte[8]; // 8 byte for 1 code
        bb.get(code); // now code in set with the 8 next bytes 129-136 ;
        Device device = new Device(code); // set Directly the code with the constructor
        devices.add(device);
    }
    return result;
   }