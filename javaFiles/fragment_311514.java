@Bean("urlUtil")
class UrlUtil {
    String doSomthing() {
       newUrl.removeParameter("page");
       newUrl.addParameter("page", "0");
       return newUrl.toString();
    }
}