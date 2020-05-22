package mypackage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RunLongProcessServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        if ("XMLHttpRequest".equals(request.getHeader("x-requested-with"))) {
            LongProcess longProcess = (LongProcess) request.getSession().getAttribute("longProcess");
            response.setContentType("application/json");
            response.getWriter().write(String.valueOf(longProcess.getProgress()));
        } else {
            request.getRequestDispatcher("runLongProcess.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        LongProcess longProcess = new LongProcess();
        longProcess.setDaemon(true);
        longProcess.start();
        request.getSession().setAttribute("longProcess", longProcess);
        request.getRequestDispatcher("runLongProcess.jsp").forward(request, response);
    }

}

class LongProcess extends Thread {

    private int progress;

    public void run() {
        while (progress < 100) {
            try { sleep(1000); } catch (InterruptedException ignore) {}
            progress++;
        }
    }

    public int getProgress() {
        return progress;
    }

}