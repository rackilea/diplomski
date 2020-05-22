package com.energy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(urlPatterns="/login.do")
@MultipartConfig
public class LoginServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;
  DataList dataLst = new DataList();

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException{
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse  response) 
        throws ServletException, IOException {
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String address = request.getParameter("aadress");
    String syKP = request.getParameter("syKP");

    PersonData person = new PersonData(name, address, syKP, email);
    dataLst.addPerson(person);
    //request.setAttribute("name", request.getParameter("name"));
    //request.setAttribute("email", request.getParameter("email"));
    //System.out.println(dataLst.getData().get(0).getNimi());

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    Gson data = new Gson();
    String tmp = data.toJson(dataLst); // won't work if you don't assign it to a string.
    response.getWriter().write(tmp);
    //request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request,     response);;
  }

}