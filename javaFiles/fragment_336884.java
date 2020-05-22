public static void main(String[] args){
    Boot.boot();

    Scanner scanner = new Scanner(System.in);
    String[] command = scanner.nextLine().trim().split(" ");
    String[] commandListOutput = Boot.command.commands.get(command[0]);
    int numbOfArgs = commandListOutput.length - 1;
    Object[][] argsArray = new String[1][numbOfArgs];
    Class<?>[] argsArrayClasses = new Class<?>[]{Object[].class};

    int i = 0;
    for(Object obj : argsArray){
        i++;
        if(i != 0){
            argsArray[0][i] = command[i];
        }
    }



    invokeMethod(null, commandListOutput[numbOfArgs], "command", argsArrayClasses, argsArray);
    scanner.close();
}