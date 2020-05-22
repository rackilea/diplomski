private Target askForTarget() {
            Target t = new Target();
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter your target:");
            t.row = input.nextInt();
            t.col = input.nextInt();
            return t;
        }