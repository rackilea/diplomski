package com.imageUpload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imageUpload.utill.DbConnection;


@WebServlet("/ImageUpload")
@MultipartConfig
public class ImageUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");

        InputStream uploadedInputStream = null;
        Part filePart = null;
        String image = "";
        filePart = request.getPart("image"); // Retrieves <input type="file" name="image">
            if (filePart != null) {
                image = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); //image->name
                uploadedInputStream = filePart.getInputStream();
            }

        FileInputStream fis=new FileInputStream(new File(image));

        Connection con=DbConnection.getConnection();
        try {   
        PreparedStatement ps=con.prepareStatement
            ("insert into image(name,image)values(?,?)");
        ps.setString(1,name);
        ps.setBinaryStream(3, fis);
        int n = ps.executeUpdate();
        if(n>0) {
            response.getWriter().println("Successfully Uploaded!");
        }

        }catch(Exception e) {System.out.println("Image E: "+e);}
    }
}