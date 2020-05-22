import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.FtpFileUpload;

/**
 * Servlet implementation class ServletCargaEvidencias
 */
@WebServlet("/ServletCargaEvidencias")
public class ServletCargaEvidencias extends HttpServlet {
private static final long serialVersionUID = 1L;

private static final String DATA_DIRECTORY = "data";
private static final int MAX_MEMORY_SIZE = 2048 * 2048 * 2;
private static final int MAX_REQUEST_SIZE = 8192 * 8192;

/**
 * @see HttpServlet#HttpServlet()
 */
public ServletCargaEvidencias() {
    super();
    // TODO Auto-generated constructor stub
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    System.out.println("IniciandoServlet Carga Evidencias");

    String ruta = request.getParameter("evidencia");



            // Revisamos que se tenga una petición multi part para carga de archivos binarios
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);

            if (!isMultipart) {
                return;
            }

            // Creamos una fabrica para archivos basados en disco.
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Revisamos los limites de tamaño para los cuales los archivos se escribe directo en disco
            factory.setSizeThreshold(MAX_MEMORY_SIZE);

            // establece un drectorio donde se almacenarán los archivos 
            // que pesen más allá de los límites permitidos
            factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

            // Construcción del folder donde el archivo se va a guardar dentro del root de nuestra web app en WEB-CONTENT
            String uploadFolder = getServletContext().getRealPath("")
                    + File.separator + DATA_DIRECTORY;

            // Creamos el manejador de carga de archivos
            ServletFileUpload upload = new ServletFileUpload(factory);

            //Establece la constante de máximo tamaño de petición
            upload.setSizeMax(MAX_REQUEST_SIZE);

            try {
                // Parea la petición
                List items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadFolder + File.separator + fileName;
                        File uploadedFile = new File(filePath);

                        //System.out.println("Este es el path del archivo feliz: " + filePath);

                        // Guarda el archivo a la carpeta interna, en el contexto de la aplicación y posteriormente la envía por FTP a un servidor
                        item.write(uploadedFile);
                        FtpFileUpload.cargarArchivos(filePath, fileName);
                    }
                }

                // Nos muetra otro servlet o jsp posteriormente a la carga
                getServletContext().getRequestDispatcher("/Secure/evidencias.jsp").forward(
                        request, response);

            } catch (FileUploadException ex) {
                throw new ServletException(ex);
            } catch (Exception ex) {
                throw new ServletException(ex);
            }







}// fin del post-----

}// fin de la clase-----