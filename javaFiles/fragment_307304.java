@RestController
public class MyController {

    private static final JsonFactory jfactory = new JsonFactory();

    @PostMapping(path = "/bigfileshere")
    public void enpointForBigFiles(HttpServletRequest request, HttpServletResponse response) {
         InputStream stream = request.getInputStream();
         try (JsonParser parser = jfactory.createParser(stream)) {
             while (parser.nextToken() != JsonToken.END_OBJECT) {
                 String fieldname = parser.getCurrentName();
                 // do other stuff
             }
         } catch (IOException e) {
         }
    }
}