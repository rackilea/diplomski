package com.engine.main;

 import java.io.IOException;
 import java.io.PrintWriter;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.concurrent.ConcurrentMap;
 import javax.naming.InitialContext;
 import javax.naming.NamingException;
 import javax.servlet.AsyncContext;
 import javax.servlet.AsyncEvent;
 import javax.servlet.AsyncListener;
 import javax.servlet.ServletConfig;
 import javax.servlet.ServletContext;
 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import sslog4java.LogLevel;
 import sslog4java.Logger;
 import com.google.gson.Gson;
 import com.DBbean.DBEngine;

 @WebServlet("/PrimaryEngine")
 public class PrimaryEngine extends HttpServlet {
      private static final long serialVersionUID = 1L;
      private DBEngine db = null;

      private static String filePath = "";
      private static String fileName = "";
      Logger fLogger = null;

      public void init(ServletConfig config) throws ServletException{
           super.init(config);
           ServletContext scxt = config.getServletContext();
           filePath = scxt.getRealPath("/WEB-INF") + "\\logs\\";
           fileName = "loggerFileName";
           fLogger = new Logger(filePath, fileName, LogLevel.DEBUG);
           try {
                // passed the servlet context into the DBengine for the pool to use
                db = new DBEngine(new InitialContext(), fLogger);
           } catch (SQLException | NamingException e) {
                e.printStackTrace();
           }
      }

      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           PrintWriter out = response.getWriter();
           if(request.getParameterMap().containsKey("param") && request.getParameter("param").equals("paramValue")){
                test = db.DBdebug();
                out.println(test);
                return;
           }
      }
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doGet(request, response);
      }
 }