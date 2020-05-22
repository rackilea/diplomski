package some.package.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.al.entity.Usuario;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "access", urlPatterns = {"*.acc"}) //This is how I receive all the .acc routes
public class access extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getServletPath();
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        Usuario usr = null;
        try {
            try{
                usr = (Usuario)request.getSession().getAttribute("usuario");
            } catch(Exception e){
                e.printStackTrace();
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if("/acceso.acc".equals(accion)){
                    PrintWriter out = response.getWriter();
                    if(usr.getTipoUsuario() == 1 || usr.getTipoUsuario() == 2 || usr.getTipoUsuario() == 3) { 
                        request.getRequestDispatcher("admLog.jsp").forward(request, response);
                    } else if(usr.getTipoUsuario() == 0){
                        request.getRequestDispatcher("uploadPDF.jsp").forward(request, response);
                    }
                    out.close();
            } else if("/salir.acc".equals(accion)){
                if(null == usr){
                    PrintWriter out = response.getWriter();
                    session.invalidate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    out.close(); 
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}