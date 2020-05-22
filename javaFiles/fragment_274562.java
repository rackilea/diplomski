//  conversion factor to map 15.0 to 0xF0
float m = (float) (0xF0 / 15.0);

for (float x = 0.0f; x <= 15.0f; x += 0.25f) {
    //  obtain byte corresponding to float
    byte b = (byte) (m * x);
    //  recover float from byte to check conversion
    //  mask off sign bit to convert signed to unsigned byte
    float r = (b & 0x0FF) / m;
    //  what is the difference between original float and 
    //  recovered float?
    float error = Math.abs(x - r);
    //  show all values for testing
    String s = " b=0x" + Integer.toHexString(b & 0x0FF) + 
               " r=" + Float.toString(r) + 
               " err=" + Float.toString(error);
    System.out.println(s);
}