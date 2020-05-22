public static void main(String[] args) {


    while (true)

    {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the phone number: ");
        String telLetter = read.next().toUpperCase();

        String telNumber = "";
        int count = 0;

        int prevCount = 0;
        for (int i = 0;i<telLetter.length (); i++)
        {

            switch (telLetter.charAt(i)) {
                case 'A':
                case 'B':
                case 'C':
                    telNumber += "2";
                    count++;
                    break;
                case 'D':
                case 'E':
                case 'F':
                    telNumber += "3";
                    count++;
                    break;
                case 'G':
                case 'H':
                case 'I':
                    telNumber += "4";
                    count++;
                    break;
                case 'J':
                case 'K':
                case 'L':
                    telNumber += "5";
                    count++;
                    break;
                case 'M':
                case 'N':
                case 'O':
                    telNumber += "6";
                    count++;
                    break;
                case 'P':
                case 'R':
                case 'Q':
                case 'S':
                    telNumber += "7";
                    count++;
                    break;
                case 'T':
                case 'U':
                case 'V':
                    telNumber += "8";
                    count++;
                    break;
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    telNumber += "9";
                    count++;
                    break;
            }
            if (count== 3 || (count - prevCount == 4)) {
                telNumber += "-";
                prevCount = count;
            }
        }

        System.out.println("---------------------------------------");
        System.out.println("Telephone Number:" + telNumber);
        System.out.println("---------------------------------------");

    }
}