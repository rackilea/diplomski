public static void main(String[] args) {
            int numeator;
            int denominator;
            double result;
            Scanner s = new Scanner(System.in);
            char m = 'y';
            do {
                try {
                System.out.print("Enter Numenator:");
                numeator = s.nextInt();

                System.out.print("Enter Denominator:");
                denominator = s.nextInt();

                result = numeator / denominator;

                System.out.println("Answer: " + result);
            } catch (InputMismatchException e) {
                System.out.println("error=> must enter integer values");
            } catch (ArithmeticException e) {
                System.out.println("error=> falseairthmtic");
            }
            System.out.println("Would you continue prees 'y' or quit press 'n'");
            m = s.next().charAt(0);
            while(m!='y'&& m!='n'){
                System.out.println("you can press only 'y'or'n' "+ m+ " is not allowed!!") ;
                m = s.next().charAt(0);
            }
        }
        while (m == 'y');
            System.out.println("Has been quit");
    }