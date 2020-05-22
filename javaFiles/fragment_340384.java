public class CustomConverter implements Converter {

@Override
public Object fromBody(TypedInput body, Type type) throws ConversionException {
    String text = null;
    try {
        text = fromStream(body.in());
    } catch (IOException e) {
        e.printStackTrace();
    }
    return text;

}

@Override
public TypedOutput toBody(Object object) {
    return null;
}

// Custom method to convert stream from request to string
public static String fromStream(InputStream in) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    StringBuilder out = new StringBuilder();
    String newLine = System.getProperty("\n");
    String line;
    while ((line = reader.readLine()) != null) {
        out.append(line);
        out.append(newLine);
    }
    return out.toString();
}
}