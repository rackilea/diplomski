public static void main(String[] args) throws InterruptedException {

Scanner startcommand = new Scanner(System.in);

System.out.println("Say Start to start game:");
String command = startcommand.nextLine();

if(command.equalsIgnoreCase("start")){

    for(int countdown = 10; countdown > 0; countdown--){

        System.out.println("Starting game in " + countdown + " seconds");
        Thread.sleep(1000);  //this line will cause the main thread to pause for 1000 ms or 1 sec
    }


}