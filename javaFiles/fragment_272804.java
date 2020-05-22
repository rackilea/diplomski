public static String deserializeString(InputStream inputStream) {
    String deserializeObject = "";
    char asciiToChar;
    int stringByteArrayLength = deserializeInt(inputStream);
    byte[] databytesArr = new byte[stringByteArrayLength];

    try {
        inputStream.read(databytesArr, 0, stringByteArrayLength);
    }
    catch (IOException e) {
        e.printStackTrace();
    }

    for (int i = 0; i < databytesArr.length; i++) {
        asciiToChar = (char) databytesArr[i];
        deserializeObject += Character.toString(asciiToChar);
    }
    return deserializeObject;
}