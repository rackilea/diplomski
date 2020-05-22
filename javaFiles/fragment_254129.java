import java.util.Scanner;

    public class Main {

    public static void main(String[] args) {

        String sInput;
        String nInput;
        double dInput;

        String sInput2;
        String nInput2;
        double dInput2;

        boolean inputOK = false;
        String operator = "";

        int decCount;
        String operatorSelect;
        double total = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            do {
                System.out.print("Enter first number: ");
                //decimals count validation reset.
                decCount = 0;
                sInput = scanner.nextLine();
                if (sInput.isEmpty()) {
                    System.out.println("Empty value Please Enter again");
                    continue;
                }
                if (!sInput.matches("^-?\\d+(,\\d+)*(\\.\\d+(e\\d+)?)?$")) {
                    System.out.println("Invalid input Please Enter again");
                    continue;
                }
                break;

                //Not needed regex will take care of everything
//                //purge !numerals || !decimals.
//                nInput = sInput.replaceAll("[^0-9.]", "");
//                //decimal count validation.
//                for (int i = 0; i < nInput.length(); i++) {
//                    if (nInput.charAt(i) == '.') {
//                        decCount = decCount + 1;
//                    }
//                }
//                //break if input valid.
//                if (decCount <= 1) {
//                    break;
//                }
            } while (true);
            dInput = Double.parseDouble(sInput);

            do {
                System.out.print("Enter second number: ");
                //decimals count validation reset.
                decCount = 0;
                sInput2 = scanner.nextLine();
                if (sInput2.isEmpty()) {
                    System.out.println("Empty value Please Enter again");
                    continue;
                }
                if (!sInput2.matches("^-?\\d+(,\\d+)*(\\.\\d+(e\\d+)?)?$")) {
                    System.out.println("Invalid input Please Enter again");
                    continue;
                }
                break;
                //purge !numerals || !decimals.
//                nInput2 = sInput2.replaceAll("[^0-9.]", "");
//                //decimal count validation.
//                for (int i = 0; i < nInput2.length(); i++) {
//                    if (nInput2.charAt(i) == '.') {
//                        decCount = decCount + 1;
//                    }
//                }
//                //break if input valid.
//                if (decCount <= 1) {
//                    break;
//                }
            } while (true);
            dInput2 = Double.parseDouble(sInput2);
            while (inputOK == false) {
                System.out.println("Operator to select: \n1) +\n2) -\n3) *\n4) /\n");
                operatorSelect = scanner.nextLine();
                switch (operatorSelect) {
                    case "1":
                        total = dInput + dInput2;
                        inputOK = true;
                        operator = "+";
                        break;
                    case "2":
                        total = dInput - dInput2;
                        inputOK = true;
                        operator = "-";
                        break;
                    case "3":
                        total = dInput * dInput2;
                        inputOK = true;
                        operator = "*";
                        break;
                    case "4":
                        total = dInput / dInput2;
                        inputOK = true;
                        operator = "/";
                        break;
                    default:
                        System.out.println("Invalid input.");
                }
            }
            System.out.println(dInput + " " + operator + " " + dInput2 + " = " + total);
            break;
        }
    }
}