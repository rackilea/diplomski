public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    // either instantiate the enclosing class, or make inputBirthday static
    inputBirthday(in);
    }

  public static void inputBirthday(Scanner abc)
 {
    System.out.print("On what day of the month were you born? ");
    int inputDay = abc.nextInt();
    System.out.print("What is the name of the month in which you were born? ");
    String inputMonth = abc.next();
    System.out.print("During what year were you born? ");
    int inputYear = abc.nextInt();
    System.out.println("You were born on " + inputMonth + " " + inputDay + "," + " " + inputYear + "." + " You're mighty old!");
    }