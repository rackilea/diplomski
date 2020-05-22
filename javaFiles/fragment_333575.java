import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Sample extends HttpServlet
{
 public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException
 {
  OutputStream out = null;
  try
  {
   response.setContentType("application/vnd.ms-excel");
   response.setHeader("Content-Disposition", "attachment; filename=sampleName.xls");
   WritableWorkbook w = Workbook.createWorkbook(response.getOutputStream());
   WritableSheet s = w.createSheet("Demo", 0);
   s.addCell(new Label(0, 0, "Hello World"));
   w.write();
   w.close();
  } catch (Exception e)
  {
   throw new ServletException("Exception in Excel Sample Servlet", e);
  } finally
  {
   if (out != null)
    out.close();
  }
 }
}