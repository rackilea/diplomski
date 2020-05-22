package com.stackoverflow.q2418355;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/SimpleServlet" })
public class SimpleServlet extends HttpServlet {
    @EJB
    SimpleEJB bean;

    private static Logger logger = LoggerFactory.getLogger(SimpleServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug(">> doGet()");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Serving at: " + request.getContextPath() + "</h2>");
        out.println("<h2>Invoking EJB: " + bean.sayHello("Duke") + "</h2>");
        out.println("</body></html>");
        logger.debug("<< doGet()");
    }
}