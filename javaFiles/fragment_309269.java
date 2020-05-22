@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {

    @Inject
    ArticuloControlador controlador;


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {


        String x=request.getParameter("x");
        int id = Integer.parseInt(x);

        articulo a = controlador.getArticuloporID(id);
        File f = a.getArchivo();

        FileInputStream inStream = new FileInputStream(f);

        String relativePath = getServletContext().getRealPath("");
        System.out.println("relativePath = " + relativePath);

        // obtengo ServletContext
        ServletContext context = getServletContext();

        // obtengo MIME del fichero
       String mimeType= URLConnection.guessContentTypeFromName(f.getName());

        if (mimeType == null) {        
            // steamos el MIME type si no lo encontramos
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        // modificamos el response
        response.setContentType(mimeType);
        response.setContentLength((int) f.length());

        // Descargamos
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", f.getName());
        response.setHeader(headerKey, headerValue);


        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inStream.close();
        outStream.close();     
    }
}