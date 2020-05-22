protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("application/xml");
    String forward = ""; 
    try {           
        String fluxXML = "";
        ServicesCodeTypeFluxGlobaux servicesCodeTypeFluxGlobaux = new ServicesCodeTypeFluxGlobauxImpl();

            fluxXML = "<lescodetypeflux>";

            fluxXML += "</lescodetypeflux>";
            PrintWriter printWriter  = response.getWriter();
            printWriter.println(fluxXML);
            printWriter.close();
        }        
    }
    catch (Exception e) {
        //print xml with error value
    }       
}