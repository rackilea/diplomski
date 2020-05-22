@Controller
public class HttpStreamProxyController {

    @RequestMapping("/spring") 
    @ResponseBody
    public StreamingResponseBody  getSecuredHttpStream() {
       if (clientIsSecured) {
       //... Security information

    RestTemplate restTemplate = new RestTemplate();
    // get video stream by connecting to stream hosting server  like this
            ResponseEntity<Resource> responseEntity = restTemplate.exchange( "https://ur-to-stream", HttpMethod.GET, null, Resource.class );
            InputStream st = responseEntity.getBody().getInputStream();
    // Or if there is any other preferred way of getting the video stream use that. The idea is to get the video input stream    

    // now return a StreamingResponseBody  object created by following lambda 
            return (os) -> {
                readAndWrite(st, os);
            };

       } else {
          return null;
       }

   }
}