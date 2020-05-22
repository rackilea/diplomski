private static void Listen(){
    serverSocket.Start ();

    while (true) {
        TcpClient Client = serverSocket.AcceptTcpClient ();
        StreamReader sr = new StreamReader(Client.GetStream ());
        string dataFromClient = sr.ReadLine();
        //Output Data From Client 
        Client.Close();
    }
}