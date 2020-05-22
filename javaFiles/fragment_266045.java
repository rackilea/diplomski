package org.myorg.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StreamingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("Connection", "keep-alive");
        response.setHeader("Transfer-Encoding", "chunked");
        for (int i = 0; i < 5; i++) {
            String str = "Line " + (i + 1) + "<br/>";
            response.getWriter().write(str);
            response.flushBuffer();
            sleep();
        }
        response.getWriter().write("DONE<br/>");
    }

    private void sleep() {
        try {
            System.out.println("Sleeping");
            Thread.sleep(500);
            System.out.println("Done sleeping");
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

}