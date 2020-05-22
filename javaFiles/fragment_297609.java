public static void main(String[] args) {
        // TODO Auto-generated method stub
        int id;
        double balance,interestRate,mir;
        Scanner in = new Scanner(System.in);
        id = in.nextInt();
        balance = in.nextDouble();
        interestRate = in.nextDouble();
        Account myPerson = new Account(id, balance, interestRate);
        myPerson.withdraw(2500.0);
        myPerson.deposit(3000.0);
        mir = myPerson.getmonthlyInterest();
        System.out.println(balance + " " + mir + " " + myPerson.getDate());

    }