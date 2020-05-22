public void fillParams(String[] args) {
    if (args.length < someMinimum) {
       // throw some exception
    }
    noOfThreads = Integer.parseInt(args[0]);
    noOfTasks = Integer.parseInt(args[1]);
    startRange = Integer.parseInt(args[2]);

    tableNames = new String[args.length - 3];
    for (int i = 0; i < tableNames.length; i++) {
       tableNames[i] = args[i + 3];
       databaseNames.add(tableNames[i]);
    }
}