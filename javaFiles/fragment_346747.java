public static void pyramid() {
        int x;
        Scanner console = new Scanner(System.in);
        System.out.println("What is the base?: ");
        x = console.nextInt();
        for (int i = 1; i <= x; i=i+2) {
            int spaceCount = (x - i)/2;  // how many space I will put for 5 firstly 2 spaces, then 1 space
            for(int j = 0; j< x; j++) {
                if(j < spaceCount || j >= (x - spaceCount)) {
                    System.out.print(" "); // put spaces before *
                } else {
                    System.out.print("*");
                }
            }
            System.out.println(); 
        }

    }