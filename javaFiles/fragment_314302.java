import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sf.json.JSONArray;

public class JSONServlet extends  HttpServlet{
  public void doGet(HttpServletRequest request,
  HttpServletResponse response)
   throws ServletException,IOException{
 JSONArray arrayObj=new JSONArray();
 arrayObj.add("D");
 arrayObj.add("A");
 arrayObj.add("L");
 arrayObj.add("D");
 arrayObj.add("A");
 arrayObj.add("TEST");
  PrintWriter out = response.getWriter();
  out.println(arrayObj);
  for(int i=0;i<arrayObj.size();i++){
  out.println(arrayObj.getString(i));
  }
 }
}