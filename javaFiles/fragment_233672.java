package controlador;

import DAO.CuentaCobroDAO;
import DTO.CuentaCobroDTO;
import DTO.contratoDTO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Calendar;


/**
*
* @author Leonardo
*/
public class CuentaCobroCtrol extends HttpServlet {

/**
 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
 * methods.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException, FileUploadException, ParseException, SQLException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();                
    String fechaIni="";
    String fechaFin="";
    String contrato="";
    String valorArl="";
    String valorEps="";
    String valorPension="";
    String valorAPagar="";
    String numeroDias="";
    String ruta="";
    String nombreArchivo="";
    String timeStamp="";
    boolean suceed=false;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
    CuentaCobroDAO ccdao= new CuentaCobroDAO();
    CuentaCobroDTO cdto= new CuentaCobroDTO();
    contratoDTO con= new contratoDTO();


    FileItemFactory ff = new DiskFileItemFactory();



    ServletFileUpload sfu = new ServletFileUpload(ff);



    List items = sfu.parseRequest(request);
    java.sql.Date fi=null, fif=null, factual=null;
    Date fechaActual;

   try{ 


       for(int i=0;i<items.size();i++){



        FileItem item = (FileItem) items.get(i);

        if (item.isFormField()){  

                         /*            A continuación validamos que los campos que vienen del formulario no estén vacios, esto en caso de que javascript falle,
        así garantizamos que tenemos todos los datos; hago esto antes de escribir el archivo en el servidor para evitar que se suba
        información que está incompleta y no debe ser subida sino hasta que se compruebe que se tienen todos los datos.*/
          if(item.getFieldName().equals("numcont")){
              contrato=getStringFromInputStream(item.getInputStream());
              out.print("<br/>  el valor de numero es: "+contrato);  
          }
          if(item.getFieldName().equals("dias")){
              numeroDias=getStringFromInputStream(item.getInputStream());
              out.print(" <br/> el valor de dias es: "+numeroDias);  
              if(numeroDias==null){
                response.sendRedirect("nomina/cuentacobro.jsp?msg= Debes ingresar los días trabajados");
                break;}else if(30<Integer.parseInt(numeroDias)){
                response.sendRedirect("nomina/cuentacobro.jsp?msg= En el mes pueden ser máximo 30 días");
                break;
            }
          }
          if(item.getFieldName().equals("valor")){
              valorAPagar=getStringFromInputStream(item.getInputStream());
              out.print(" <br/> el valor  es: "+valorAPagar); 
              if(Integer.parseInt(valorAPagar)<=0 || valorAPagar==null){
                  response.sendRedirect("nomina/cuentacobro.jsp?msg= El valor no puede ser nagativo o nulo. Por favor ingresa el valor a pagar");
              }
          }
          if(item.getFieldName().equals("arl")){
              valorArl=getStringFromInputStream(item.getInputStream());
              out.print(" <br/> el valor de arl es: "+valorArl);  
              if(valorArl==null){
                response.sendRedirect("nomina/cuentacobro.jsp?msg= Tienes que ingresar el valor de la ARL");
                break;
            }
          }
          if(item.getFieldName().equals("eps")){
              valorEps=getStringFromInputStream(item.getInputStream());
              out.print(" <br/> el valor de eps es: "+valorEps);  
              if(valorEps==null){
                response.sendRedirect("nomina/cuentacobro.jsp?msg= Es necesario ingresar el valor de la EPS");
                break;
            }
          }
          if(item.getFieldName().equals("pension")){
              valorPension=getStringFromInputStream(item.getInputStream());
              out.print(" <br/> el valor de pension es: "+valorPension); 
              if(valorPension==null){
                response.sendRedirect("nomina/cuentacobro.jsp?msg= Debes ingresar el valor de pensión");
                break;
            }
          }
           if(item.getFieldName().equals("fechai"))  
        {  
            fechaIni=getStringFromInputStream(item.getInputStream());
            out.print("el valor de fechaInicial es: "+fechaIni);
            if(fechaIni==null || fechaIni.length()<4){
                response.sendRedirect("nomina/cuentacobro.jsp?msg= Error, no ingresaste el valor de fecha periodo inicial");
            }
        }
          if(item.getFieldName().equals("fechaf")){
              fechaFin=getStringFromInputStream(item.getInputStream());
              fechaActual=  new Date();
            Date inicial=formatter.parse(fechaIni);
            fi= new java.sql.Date(inicial.getTime());
            Date ffinal=formatter.parse(fechaFin);
            fif= new java.sql.Date(ffinal.getTime());
            factual=new java.sql.Date(fechaActual.getTime());
            if(fi.compareTo(factual)>0 || fif.compareTo(factual)>0){
                response.sendRedirect("nomina/cuentacobro.jsp?msg="+"Error, no puedes ingresar una cuenta del mes futuro o actual");
                break;
            }

          }
     }

        if(!item.isFormField()){
               timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
               ruta="/archivos/pdf/"+request.getSession(false).getAttribute("iduser")+"/";
               nombreArchivo=request.getSession(false).getAttribute("iduser")+"-"+timeStamp+".pdf";
                    File dir=new File(ruta+nombreArchivo);
                    dir.mkdirs();
                    File archivoAServidor= new File(getServletContext().getRealPath(ruta+nombreArchivo));

                    try {
                        item.write(archivoAServidor);
                        suceed=true;
                    } catch (Exception ex) {
                        Logger.getLogger(CuentaCobroCtrol.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
    }
    if(suceed==true){
        cdto.setFinicial(fi);
            cdto.setFfinal(fif);
            cdto.setDias(Integer.parseInt(numeroDias));
            cdto.setHoras(Integer.parseInt("0"));
            cdto.setPagoArl(Integer.parseInt(valorArl));
            cdto.setPagoEps(Integer.parseInt(valorEps));
            cdto.setPagoPension(Integer.parseInt(valorPension));
            cdto.setIdContratista((Integer)request.getSession(false).getAttribute("iduser"));
            cdto.setValorAPagar(Integer.parseInt(valorAPagar));
            con.setIdCONTRATO((Integer)request.getSession(false).getAttribute("idContrato"));
            cdto.setRutaDocumento(ruta+nombreArchivo);
            String salida=cdto.insertCuenta(cdto, con);
            response.sendRedirect("nomina/cuentacobro.jsp?msg="+salida);
    }



   }catch(IOException iex){
       throw iex;
   }catch(ParseException pex){
       throw pex;
   }






    try {
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CuentaCobroCtrol</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet CuentaCobroCtrol at " + request.getContextPath() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    } finally {
        out.close();
    }
}

private static String getStringFromInputStream(InputStream is) {

    BufferedReader br = null;
    StringBuilder sb = new StringBuilder();

    String line;
    try {

        br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    return sb.toString();

}


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (FileUploadException ex) {
        Logger.getLogger(CuentaCobroCtrol.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(CuentaCobroCtrol.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CuentaCobroCtrol.class.getName()).log(Level.SEVERE, null, ex);
    }
}

/**
 * Handles the HTTP <code>POST</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    try {
        processRequest(request, response);
    } catch (FileUploadException ex) {
        Logger.getLogger(CuentaCobroCtrol.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ParseException ex) {
        Logger.getLogger(CuentaCobroCtrol.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(CuentaCobroCtrol.class.getName()).log(Level.SEVERE, null, ex);
    }
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
@Override
public String getServletInfo() {
    return "Short description";
}// </editor-fold>

}