private float getRealRegisterValue(int register1, int register2) {
     //Get binary string of register values
     String s1 = Integer.toBinaryString(register1);
        String s2 = Integer.toBinaryString(register2);

    //Append them respectively
    String b=s1+"s2";

    //get integer values 
    int intBits = Integer.parseInt(b, 2);
    System.out.println(intBits);
    //get float real value from IEEE 754 format
    float realValue = Float.intBitsToFloat(intBits);
    return realValue;   
}