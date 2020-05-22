Scanner input = new Scanner(System.in);
// infinite loop
while (true){
        System.out.println("Input the maximum temperature.");
        try {
            int maxTemp = input.nextInt();
            // TODO whatever you need to do with max temp
        }
        catch (Throwable t) {
            // TODO handle better
            t.printStackTrace();
            break;
        }
        System.out.println("Input the minimum temperature.");
        try {
            int minTemp = input.nextInt();
            // TODO whatever you need to do with min temp
        }
        catch (Throwable t) {
            // TODO handle better
            t.printStackTrace();
            break;
        }
}