package com.javavirtues.sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String fileName = req.getPathInfo();
        InputStream resourceContent = getServletContext()
                .getResourceAsStream("/WEB-INF/classes/uploads" + fileName);
        if (resourceContent == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            OutputStream outputStream = resp.getOutputStream();
            byte[] buffer = new byte[1024];
            for (int length = 0; (length = resourceContent.read(buffer)) > 0;) {
                outputStream.write(buffer, 0, length);
            }
        }
    }
}