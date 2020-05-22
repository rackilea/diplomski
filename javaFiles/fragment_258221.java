public class CodecFactory {
    final private static Map<String, Class<? extends CodecInterface>> codecLibrary;

    static {
        codecLibrary = new HashMap<String, Class<? extends CodecInterface>>();
        codecLibrary.put("codec1", Codec1.class);
        //...
    }

    static CodecInterface create(String filename, String codecid, String args) throws InstantiationException, IllegalAccessException {
        Class<? extends CodecInterface> clazz;

        clazz = codecLibrary.get(codecid);

        CodecInterface codec = clazz.newInstance();

        codec.setArgs(args);
        codec.setFilename(filename);

        return codec;
    }
}