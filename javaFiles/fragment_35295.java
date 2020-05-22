@Slf4j
@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(productionMode = true, ui = NewUi.class, widgetset = "fi.ssm.ressu.NewWidgetSet",
    heartbeatInterval = 60, closeIdleSessions = true)
public class NewServlet extends SpringVaadinServlet {

}