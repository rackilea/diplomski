int arr[]=new int[10];
Scanner inFromUser= new Scanner(System.in);
try (Socket clientSocket = new Socket("localhost",6786)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
    for(int i=0;i<10;i++)
        arr[i]=inFromUser.nextInt();

    outToServer.writeObject(arr);
    int[] arrFromServer = (int[])inFromServer.readObject();
    for (int i = 0; i < arrFromServer.length; i++) {
        System.out.println("From Server::"+arrFromServer[i]);
    }
}