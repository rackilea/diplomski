@WebServlet(
    urlPatterns = {
            "/VAADIN/*", "/frontend/*"
    },
    initParams = {
            @WebInitParam(name = "productionMode", value = "false")
    })
public class MyServlet extends VaadinServlet {}