public class stringToHex {
    public static void main(String[] args) throws UnsupportedEncodingException { //exception is necessary to convert to a byte array
        String test = "Hello World";
        byte[] bytes = test.getBytes("UTF-8"); //make a byte array out of the string
        System.out.println(DatatypeConverter.printHexBinary(bytes)); //use DatetypeConverter to convert binary to hex
    }
}