package testingThings.ServerSentEvent;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, value = {"/ServerSentEvent"})
public class ServerSentEvent extends HttpServlet { 
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // add @WebServlet(asyncSupported = true) instead
        // http://stackoverflow.com/questions/7855712/how-to-avoid-request-set-async-supported-true-to-enable-async-servlet-3-0-proces
        // req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);

        resp.setContentType("text/event-stream");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Connection", "keep-alive");
        resp.setCharacterEncoding("UTF-8");

        AsyncContext aCtx = req.startAsync(req, resp);
        aCtx.setTimeout(80000);

        // add a asyncContext a session Attribute
        req.getSession().setAttribute("asyncContext", aCtx);

        //start logging in listener
        req.getSession().setAttribute("entryProcessorProgress", "trigger output");
    }
}