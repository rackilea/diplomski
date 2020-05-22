public static void main(String[] args) {
    try {
        // Encode a String into bytes
        String inputString = "Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar Tu hi bata Pehla nasha Pehla khumaar Udta hi firoon in hawaon mein kahin Ya main jhool jaoon in ghataon mein kahin Udta hi firoon in hawaon mein kahin Ya main jhool jaoon in ghataon mein kahin Ek kar doon aasmaan zameen Kaho yaaron kya karoon kya nahin Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar Tu hi bata Pehla nasha Pehla khumaar Usne baat ki kuchh aise dhang se Sapne de gaya vo hazaaron range ke Usne baat ki kuchh aise dhang se Sapne de gaya vo hazaaron range ke Reh jaoon jaise main haar ke Aur choome vo mujhe pyaar se Pehla nasha Pehla khumaar Naya pyaar hai naya intezaar Kar loon main kya apna haal Aye dil-e-bekaraar Mere dil-e-bekaraar";
        byte[] input = inputString.getBytes("UTF-8");

        // Compress the bytes
        byte[] output1 = new byte[input.length];
        Deflater compresser = new Deflater();
        compresser.setInput(input);
        compresser.finish();
        int compressedDataLength = compresser.deflate(output1);
        compresser.end();

        String str = Base64.encode(output1);
        System.out.println("Deflated String:" + str);

        byte[] output2 = Base64.decode(str);

        // Decompress the bytes
        Inflater decompresser = new Inflater();
        decompresser.setInput(output2);
        byte[] result = str.getBytes();
        int resultLength = decompresser.inflate(result);
        decompresser.end();

        // Decode the bytes into a String
        String outputString = new String(result, 0, resultLength, "UTF-8");
        System.out.println("Deflated String:" + outputString);
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (DataFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}