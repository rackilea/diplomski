package com.tugay.listeners;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        final String name = httpServletRequest.getParameter("name");
        final DataSource datasource
                = (DataSource) getServletContext().getAttribute("datasource");
        try {
            final Connection connection = datasource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + "app_user" + "(username) VALUES(?)");
            preparedStatement.setString(1, name);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}