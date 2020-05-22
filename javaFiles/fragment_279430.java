ServerSocket someSocket = new ServerSocket(1666);
Socket socket = someSocket.accept();

OutputStream out = socket.getOutputStream();
BufferedReader in =
    new BufferedReader(
        new InputStreamReader(socket.getInputStream()));

System.out.println(Thread.currentThread().getName() +  " socket accepted");

String data = in.readLine();
System.out.println(data);

System.out.println("data received");
out.write("ACK\r\n".getBytes());

out.flush();
System.out.println("data sent");
socket.close();
someSocket.close();