@Override
public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
{
    System.out.println("service(ServletRequest req, ServletResponse res)");

    res.setContentType("text/plain");

    try
    {
        ObjectInputStream in = new ObjectInputStream(req.getInputStream());
        slideData = (MultipleSlideDataObject2)in.readObject();
        in.close();

        String reply = "Failed";

        if(slideData != null)
        {
            System.out.println("Serial number of submitted slide series is: " + slideData.getSerialNumber());

            FacesContext facesContext = FacesUtil.getFacesContext(req, res);
            ProductSelection productSelection = (ProductSelection) facesContext.getApplication().evaluateExpressionGet(facesContext, "#{productSelection}", ProductSelection.class);
            productSelection.submitSearchCriteriaFile(slideData);

            reply = "Success";
        }

        ObjectOutputStream outputToApplet = new ObjectOutputStream(res.getOutputStream());
        outputToApplet.writeObject(reply);
        outputToApplet.flush();          
        outputToApplet.close();
    }
    catch (ClassNotFoundException ex)
    {
        Logger.getLogger(CriteriaServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
}