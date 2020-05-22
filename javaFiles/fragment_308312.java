public void run(String[] args) {
    // parse the file from args and store data
    firstClass = new first();
    firstClass.run(args);
    dataFromFirst = firstClass.getSomeData();
}