package com.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.util.Map;
import java.util.HashMap;

import java.io.IOException;

public class TestMapServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        Integer noValueInt = null;
        Integer one = new Integer(1);
        Integer two = new Integer(2);

        map.put(noValueInt, "Default object for null Integer key");
        map.put(one, "Object for key = Integer(1)");
        map.put(two, "Object for key = Integer(2)");

        request.setAttribute("map", map);
        request.setAttribute("noValueInt", noValueInt);
        request.setAttribute("one", one);
        request.setAttribute("two", two);

        request.getRequestDispatcher("/test-map.jsp").forward(request, response);
    }
}