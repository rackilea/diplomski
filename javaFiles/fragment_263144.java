@MountPath(value = "/api/my/rest/url")
public class MyPostHandler extends SecureWebPage {

    public MyPostHandler () {
        final WebRequest webRequest = (WebRequest) getRequest();
        final HttpServletRequest rawRequest = (HttpServletRequest) webRequest.getContainerRequest();

        if (rawRequest.getMethod().equalsIgnoreCase("POST")) {

            BufferedReader br;
            try {
                br = rawRequest.getReader();
                String jsonString = br.readLine();
                //Do something with the JSON here
            }
            catch (IOException e) {

            }

        }
    }
}