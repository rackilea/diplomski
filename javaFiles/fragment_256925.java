public class CsvDownloadServlet extends HttpServlet
{
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
{
    // fetch parameters from HTTP request

    String param = (String)request.getParameter("p");
    if (param == null)
    {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Parameter p missing");
        return;
    }

    .... perhaps fetch more parameters ....

    .... build your CSV, using the parameter values ....

    String result = .... // suppose result is your generated CSV contents
    String filename = .... // choose a file name that your browser will suggest when saving the download

    // prepare writing the result to the client as a "downloadable" file

    response.setContentType("text/csv");
    response.setHeader("Content-disposition", "attachment; filename=\""+filename+"\"");
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Expires", "-1");

    // actually send result bytes
    response.getOutputStream().write(result.getBytes());
}
}