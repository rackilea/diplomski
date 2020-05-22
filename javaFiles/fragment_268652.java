public class SomeCustomRetrofitConverter implements Converter {

    private GsonBuilder gb;

    public SomeCustomRetrofitConverter() {
        gb = new GsonBuilder();

        //register your cursom custom type serialisers/deserialisers if needed
        gb.registerTypeAdapter(SomeCutsomType.class, new SomeCutsomTypeDeserializer());
    }

    public static final String ENCODING = "UTF-8";

    @Override
    public Object fromBody(TypedInput body, Type type) throws ConversionException {
        String charset = "UTF-8";
        if (body.mimeType() != null) {
            charset = MimeUtil.parseCharset(body.mimeType());
        }
        InputStreamReader isr = null;
        try {
           isr = new InputStreamReader(body.in(), charset);
           Gson gson = gb.create();
           return gson.fromJson(isr, type);
        } catch (IOException e) {
            throw new ConversionException(e);
        } catch (JsonParseException e) {
            throw new ConversionException(e);
        } finally {
            if (isr != null) {
                   try {
                      isr.close();
                   } catch (IOException ignored) {
                }
            }
        }
    }

    @Override
    public TypedOutput toBody(Object object) {
        try {
            Gson gson = gb.create();
            return new JsonTypedOutput(gson.toJson(object).getBytes(ENCODING), ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
     }

    private static class JsonTypedOutput implements TypedOutput {
        private final byte[] jsonBytes;
        private final String mimeType;

        JsonTypedOutput(byte[] jsonBytes, String encode) {
            this.jsonBytes = jsonBytes;
            this.mimeType = "application/json; charset=" + encode;
        }

        @Override
        public String fileName() {
            return null;
        }

       @Override
       public String mimeType() {
           return mimeType;
       }

       @Override
       public long length() {
          return jsonBytes.length;
       }

       @Override
       public void writeTo(OutputStream out) throws IOException {
           out.write(jsonBytes);
       }
    }
 }