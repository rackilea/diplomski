public class BlueJays {
    static String name[] = new String[3]; //Name Array that can hold 10 names
    static int age[] = new int[3]; //Age Array that can hold 10 ages
    static String position[] = new String[3]; //Position Array that can hold 10 positions
    static double average[] = new double[3]; //Average Array the can hold 10 batting averages
    static int x, i;

    //Main Method
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int menuChoice = 1;
        System.out.print("Hello and Wlecome to Blue Jay Java Sort");

        while (menuChoice != 3) {

            System.out.print("\rEnter Menu Choice\n");
            System.out.print("**********************");
            System.out.print("\r(1) => Enter Blue Jay Data \n");
            System.out.print("(2) => Display Possible Draft Choices \n");
            System.out.print("(3) => Exit \r");

            //try-catch statement for each case scenario
            try {
                menuChoice = Integer.parseInt(br.readLine());
            } catch (IOException ie) {
                ie.printStackTrace();
            }

            switch(menuChoice) {
            case 1:
                inputInfo();
                break;
            case 2:
                inputSort();
                break;
            case 3:
                return;
            }
        }
    }

    public static void inputInfo() throws IOException { 

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        Scanner p = new Scanner(System.in); 

        //loop to request to fill array   
        for (x = 0; x < 3; x++) {

            //Ask for player name
            System.out.print("\rEnter player full name: ");
            //Read input and store name in an Array
            name[x] = in.readLine();

            //Ask for player age  
            System.out.print("Enter age of player: ");
            //Read input and store age in an Array
            age[x] = p.nextInt();

            //Ask for position of player
            System.out.print("Enter player position: ");
            //Read input and store position in an Array
            position[x] = in.readLine();

            //Ask for batting average of player
            System.out.print("Enter batting average of player: ");
            //Read input and store batting average in an Array
            average[x] = p.nextDouble();
        }
    }


    public static void inputSort() {

        int smallest, temp;

        //Selection Sort
        for (x = 0; x < 3 - 1; ++x) {

            smallest = x;

            for(i = x + 1; i < 3; ++i) {
                if (age[i] < age[smallest]) {
                    smallest = i;
                }
            }

            temp = age [x];
            age [x] = age [smallest];
            age [smallest] = temp;
        }

        System.out.println(" Name " + " -----" + " Age " + "-----" + " Position "  + "-----" + "Batting Average "); 

        for (x = 0 ; x < 3; x++) {
            if (age[x] <= 25 && average[x] >= .280) {
                System.out.println( name[x] + " ----- " + age[x] + " ----- " + position[x] + " ----- " + average[x]);
            }
        }

        //Close Main()  
    }
}