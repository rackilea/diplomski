@Provider
@Produces(MediaType.APPLICATION_JSON)
public class TextMessageBodyWriter 
    implements MessageBodyWriter<EditorStoryChapterInput> {

    @Override
    public boolean isWriteable(Class type, Type type1, 
            Annotation[] antns, MediaType mt) {
        return type == EditorStoryChapterInput.class;
    }

    @Override
    public long getSize(EditorStoryChapterInput t, Class<?> type, 
            Type type1, Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(EditorStoryChapterInput input, Class<?> type,
            Type type1, Annotation[] antns, MediaType mt, 
            MultivaluedMap<String, Object> mm, OutputStream out) 
            throws IOException, WebApplicationException {

        Text title = input.getTitle();
        JsonObject jsonObject = 
                Json.createObjectBuilder()
                .add("title", title.toString()).build();

        try (JsonWriter jsonWriter = Json.createWriter(out)) {
            jsonWriter.writeObject(jsonObject);
        }
    }
}