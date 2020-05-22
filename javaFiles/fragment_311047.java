try {

        FileWriter ac = new FileWriter("D:\\programming\\Java\\JavaBanking\\Transactions.txt",true);
        BufferedWriter fw = new BufferedWriter(ac);

        String message = String.format(
                "You have chosen the following amount: %d %n the number: %d Is the chosen number",
                 amount, 
                 getNumber());

        fw.write(message);

        fw.close();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }