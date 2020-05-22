import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Converts farenheit to celcius
public class TemperatureServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String str_f = req.getParameter("Fahrenheit");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            int temp_f = Integer.parseInt(str_f);
            double temp_c = (temp_f - 32) * 5.0 / 9.0;
            out.print("Fahrenheit: " + temp_f + ", Celsius: " + temp_c);
        } catch (NumberFormatException e) {
            out.print("Invalid temperature: " + str_f);
        }
    }
}