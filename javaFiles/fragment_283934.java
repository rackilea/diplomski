public class HttpTest {
public static void main(String[] args) {
        HttpClient client = HttpClient
                .newBuilder()
                .version(Version.HTTP_2)
                .build();

        String query ="//Controller/Components/Path/DataItems/DataItem[@type=\"PART_COUNT\"]";
        String encodedQuery = encodeValue(query);
        System.out.println(encodedQuery);
        System.out.println();
        java.net.http.HttpRequest.Builder builder;



        try {
            builder = HttpRequest.newBuilder(new URI("http://.........../current?path="+encodedQuery));
            HttpRequest request =  builder.GET().build();

                HttpResponse httpResponse = client.send(request, BodyHandlers.ofString());
             String body = (String) httpResponse.body();
             System.out.println(body);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}