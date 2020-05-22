@Component(immediate = true, metatype = false, label = "feedServlet")
@Service(Servlet.class)
@Properties(value = {
    @org.apache.felix.scr.annotations.Property(name = "sling.servlet.methods", value = "POST"),
    @org.apache.felix.scr.annotations.Property(name = "sling.servlet.paths", value ="/bin/feedServlet"))
})
public class FeedServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = -2139716879248038562L;

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServerException,
            IOException {

        String feed = "test test test";

        response.getWriter().write(feed);
    }
}