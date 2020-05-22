try {
    // ...

    new AutoFileCloser() {
        @Override protected void doWork() throws Throwable {
            // declare variables for the readers and "watch" them
            FileReader fileReader = 
                    autoClose(fileReader = new FileReader("somefile"));
            BufferedReader bufferedReader = 
                    autoClose(bufferedReader = new BufferedReader(fileReader));

            // ... do something with bufferedReader

            // if you need more than one reader or writer
            FileWriter fileWriter = 
                    autoClose(fileWriter = new FileWriter("someOtherFile"));
            BufferedWriter bufferedWriter = 
                    autoClose(bufferedWriter = new BufferedWriter(fileWriter));

            // ... do something with bufferedWriter
        }
    };

    // .. other logic, maybe more AutoFileClosers

} catch (RuntimeException e) {
    // report or log the exception
}