class HandleAClient implements Runnable {

    private Socket socket; // A connected socket
    private double rate;
    private int year;
    private double loan;

    private final TextArea textArea ;

    public HandleAClient(Socket socket, TextArea textArea)
    {
        this.socket = socket;
        this.textArea = textArea ;
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

                rate = inputFromClient.readDouble();
                year = inputFromClient.readInt();
                loan = inputFromClient.readDouble();


                // calculate monthly payment of loan and total payment

                outputToClient.writeDouble(calculateMonthlyPayment(rate, year, loan));
                outputToClient.writeDouble(calculateTotalPayment(rate, year, loan));

                Platform.runLater( () -> {
                    textArea.appendText("The rate is : " + rate + "\n");
                    textArea.appendText("The number of years is: " + year + "\n");
                    textArea.appendText("Loan amount is: " + loan + "\n\n");});

            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}