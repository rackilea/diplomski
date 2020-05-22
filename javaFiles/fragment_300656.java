public class MyServiceImpl extends RemoteServiceServlet implements MyService {

  public String getHtmlSnippet(String param) {

    String html = buildHtmlSnippetInASafeWay(param); // Use any (safe) HTML
                                                     // builder you like. (this
                                                     // is not GWT related!)
    return html;
  }
}