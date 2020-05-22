try{
    ServerSocket socket = new ServerSocket(80);
    Socket response = socket.accept();
    String lol = "<html>hi</html>";
    writer = new PrintStream(response.getOutputStream());
    writer.println("HTTP/1.1 200 OK");
    writer.println("Content-Type: text/html");
    writer.println();
    writer.println(lol);
    writer.flush();
    response.close();
    System.out.println("LOL works!");
    }catch(IOException e)
    {
        e.printStackTrace();
    }
}