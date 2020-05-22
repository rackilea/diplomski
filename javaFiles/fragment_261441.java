public class VaadinApp extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = VaadinApp.class)

    public static class Servlet extends VaadinServlet {
    }

     VistaPrincipal vp;

    @Override
    protected void init(VaadinRequest request) {
         final VerticalLayout layout = new VerticalLayout();

         VistaPrincipal vp = null;

         vp = new VistaPrincipal();

         if(request.getParameter("parameter") != null) {
             Notification.show("Success");
         // show the parameter in GET request
             System.out.println("parameter:" + request.getParameter("parameter"));
        }

        layout.addComponent(vp);
        layout.setComponentAlignment(vp, Alignment.TOP_CENTER);
        layout.setMargin(false);
        setContent(layout);

    }

}