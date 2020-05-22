final static String DATE_FORMAT = "dd-MM-yyyy";

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int intJour;
    int intMois;
    int intAnnee;

    do {
        System.out.println("Veuillez entrer votre année de naissance :");
        intAnnee = sc.nextInt();
        sc.nextLine();
    } while (intAnnee < 0 || intAnnee > Calendar.getInstance().get(Calendar.YEAR));

    do {
        System.out.println("Veuillez entrer votre mois de naissance (de 01 à 12) :");
        intMois = sc.nextInt();
        sc.nextLine();
    } while (intMois < 0 || intMois > 12);

    do {
        System.out.println("Veuillez entrer votre jour de naissance (de 01 à 31) :");
        intJour = sc.nextInt();
        sc.nextLine();
    } while (!isDateValid(intAnnee, intMois, intJour));

    System.out.println("Confirmation de votre année de naissance: " + intJour + "-" + intMois + "-" + intAnnee);
    sc.close();
}

public static boolean isDateValid(int year, int month, int day) 
{
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(day + "-" + month + "-" + year);
            return true;
        } catch (ParseException e) {
            return false;
        }
}