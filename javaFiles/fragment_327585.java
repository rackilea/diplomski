public class Example {
  public static void main(String[] args) {
    JsonpApi jsonpApi = Feign.builder()
         .mapAndDecode((response, type) -> jsopUnwrap(response, type), new GsonDecoder())
         .target(FeignInterface.class, apiUrl);
  }
}