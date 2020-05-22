package com.example.jartest;

import java.io.*;
import java.nio.file.*;
import java.sql.*;

public class JarTestMain {

    public static void main(String[] args) {
        String mdbFileName = "JarData.mdb";
        String tempDbPath = System.getenv("TEMP").replace('\\', '/') + "/" + mdbFileName; 

        // retrieve .mdb database from the JAR file and save to %TEMP% folder
        InputStream strmIn = JarTestMain.class.getResourceAsStream("resources/" + mdbFileName);
        File f = new File(tempDbPath);
        try {
            Files.copy(strmIn, f.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // open the copy of the database in %TEMP% folder and read from its table
        String connectionString = 
                "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};" +
                "DBQ=" + tempDbPath;
        try (Connection con = DriverManager.getConnection(connectionString)) {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM Table1");
            while (rs.next()) {
                System.out.println(String.format(
                        "%d: %s", 
                        rs.getInt("ID"), 
                        rs.getString("TextField")));
            }
            rs.close();
            con.close();
            f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}