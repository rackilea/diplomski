public static void main(String[] args) {

        //declaring
        Scanner input = new Scanner(System.in);

        //inputs
        System.out.println("Enter in the double with this format (A + B(x)^2)^2");

        System.out.print("A --> ");
        double A = input.nextInt();

        System.out.print("B --> ");
        double B = input.nextInt();
        input.close();

        System.out.println("You're Equation: (" + A + " + " + B + "x^2)^2");

        //Math
        //A + C + B
        double A2 = Math.pow(A, 2);
        /**  old code:
         * 
        double B2 = Math.pow(B, 2);

        double C = 2 * (A * B);
        */     
        /** replacement : */
        //Y(1)=(A + B*(1)^2)^2 = (A+B)^2
        //Y(-1)=(A + B*(-1)^2)^2 = (A+B)^2
        //B2 = (Y(1)-Y(-1))/2 = ((A+B)^2 -(A+B)^2)/2 = 0
        double B2=0; // it is always 0 in this case
        //Y(1)=(A + B*(1)^2)^2 = (A+B)^2
        double C2=(A+B)*(A+B) - A2; //Y(1) -A2 
        //final
        System.out.print("You answer: ");
        System.out.println(A2 + " + " + B2 + "x" + " + " + C2 + "x^2");
    }