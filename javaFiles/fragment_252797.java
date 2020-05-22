public static void main(String[] args) {
        int saldo = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("[I]nsättning");
            System.out.println("[U]ttag");
            System.out.println("[S]aldo");
            System.out.println("[A]vsluta");
            String menu = scan.next();
            switch (menu) {
            case ("i"):
                System.out.print("Hur mycket pengar vill du sätta in på ditt konto? : ");
                String str = scan.next();
                int insättning = Integer.parseInt(str);
                saldo = saldo + insättning;
                break;
            case ("s"):
                System.out.println("Du har : " + saldo + "kr på ditt konto");
                break;

            }
        }
    }