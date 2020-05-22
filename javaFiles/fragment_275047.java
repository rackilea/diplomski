@ControllerAdvice
public class ControllersAdvice {
@ModelAttribute("headerData")
public HeaderData getHeaderData(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
    HeaderData headerData = new HeaderData();
    // Get the header data and cache it. Set the cache timeframe to 1 day or whatever you want the frequency to be. This will be done using Spring @cacheable annotation.
    // dump all the data that you want to headerData like logo, title , link etc
    return headerData;
}
}