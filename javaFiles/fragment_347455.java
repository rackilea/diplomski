<%@ page contentType="text/html" import="java.io.*, java.net.*" %>

<% 
        try {
            Socket s = new Socket("another.apache.com", 80);

            BufferedReader in = new BufferedReader(new 
            InputStreamReader(s.getInputStream()));
            PrintWriter socketOut = new PrintWriter(s.getOutputStream());

            socketOut.print("GET /index.html\n\n");
            socketOut.flush();

            String line;

            while ((line = in.readLine()) != null){
                out.println(line);
            }

        } catch (Exception e){}
%>