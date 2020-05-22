package com.lcdss.compmng.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lcdss.compmng.entity.Computer;

public class ComputerSV extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ArrayList<Computer> computers = new ArrayList<>();

        computers.add(
            new Computer(
                1,
                "HP",
                "hostname",
                "Windows 10 Pro x64",
                "Intel I7 7700K 4.2 GHz",
                2048,
                8196,
                "Anapolis"
            )
        );

        computers.add(
            new Computer(
                2,
                "DELL",
                "hostname",
                "Windows 10 Home Basic x64",
                "Intel I7 7500U 2.5 GHz",
                512,
                4098,
                "Goiania"
            )
        );

        request.setAttribute("computers", computers);
        request.getRequestDispatcher("computer/index.jsp").forward(request, response);
    }
}