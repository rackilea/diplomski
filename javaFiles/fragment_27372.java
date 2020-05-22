public class Application {
    //Add extends Document after T
    public static <T extends Document> T createDocument(Class<T> documentClass) throws InstantiationException, IllegalAccessException {
        return documentClass.newInstance();
    };
}