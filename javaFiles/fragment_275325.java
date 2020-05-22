public static void main(String args[]) {
    Scanner src;
    String amount = null;
    String counterparty = null;
    String dt = null;
    String ct = null;
    System.out.println("Create new transaction:yes/no");
    Scanner abc = new Scanner(System.in);
    String g = abc.nextLine();
           if (g.equals("yes"))
                   {
        System.out.println("Amount of transaction:");
         src = new Scanner(System.in);
        amount = src.nextLine();
        System.out.println("Counterparty:");
         counterparty = src.nextLine();
        System.out.println("Dt:");
         dt = src.nextLine();
        System.out.println("Ct:");
         ct = src.nextLine();
    }
  else if (g.equals("no")){
   amount="0";
    }

    System.out.println("Transaction:");
    ArrayList <String> Provodka = new ArrayList();
    Provodka.add(amount);
    Provodka.add(counterparty);
    Provodka.add(dt);
    Provodka.add(ct);
    for (int i = 0; i < Provodka.size(); i++) {
        String value = Provodka.get(i);
        System.out.println("Element: " + value);
    }
}