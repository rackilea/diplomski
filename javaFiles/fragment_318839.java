public static void main(String[] args) {
        int pitcher;
        Scanner user = new Scanner(System.in);
        int lemons_per_pitcher = 12;
        int spoons_per_bag = 1000;
        int spoons_per_pitcher = 50;
        System.out.println("Enter the amount of lemons you have.");
        int lemon = user.nextInt();
        System.out.println("Enter the amount of bags of sugar you have.");
        int bags = user.nextInt();
        int spoons = bags * 1000;
        int sugar = spoons / 50;
        int lemons2 = lemon / 12;
        if (lemons2 > sugar) {
            pitcher = lemons2;
        } else {
            pitcher = sugar;
        }
        if (lemon < 12 || bags < 1) {
            System.out.println("You can make a maximum of 0 pitchers");
        } else {
            System.out
                    .println("This is the maximum amount of pitchers you can         make is: "
                            + pitcher);
        }
    }