public static byte[] serialize(Quiz quiz) throws IOException{
    ...
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ...
    return baos.toByteArray();
}

@SuppressWarnings("unchecked")
public static Quiz deserialize(byte[] serializedQuizData) throws IOException, ClassNotFoundException{
    ByteArrayInputStream bais = new ByteArrayInputStream(serializedQuizData);
    ...
    return quiz;
}