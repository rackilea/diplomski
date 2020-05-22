public boolean add() {
        boolean result = false;
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the Artist name and the CD title: ");
        CD yourCD = new CD(input.nextLine(), input.nextLine());
        System.out.println("Enter the number of songs: ");
        int songNum = input.nextByte();
        System.out.println("Enter the name of the songs: ");

        for (int i = 0; i <= songNum; i++) {
            yourCD.addTrack(input.nextLine());
        }
        CDlist[cdnum] = yourCD;


        if (rear == front) {
            result = false;
        } else {
            if (CDlist[rear] != null) {
                rear--;
            } else {
                CDlist[rear] = yourCD;
            }
            result = true;
        }
        return result;    

    }