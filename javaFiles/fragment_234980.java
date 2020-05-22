class HandleAClient implements Runnable {

    private Socket socket; // A connected socket

    private final Consumer<LoanData> dataProcessor ;

    public HandleAClient(Socket socket, Consumer<LoanData> dataProcessor)
    {
        this.socket = socket;
        this.dataProcessor = dataProcessor ;
    }

    /** run a thread */
    public void run(){
        try
        {
            // create data input and output streams
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            // continuously serve the client
            while(true) {
                // read data from client

                double rate = inputFromClient.readDouble();
                double year = inputFromClient.readInt();
                double loan = inputFromClient.readDouble();


                // calculate monthly payment of loan and total payment

                outputToClient.writeDouble(calculateMonthlyPayment(rate, year, loan));
                outputToClient.writeDouble(calculateTotalPayment(rate, year, loan));

                dataProcessor.accept(new LoanData(rate, year, loan));

            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}