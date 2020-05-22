/// ! I don't test the code,  any question ,reply me.

// new stream for receive data. 
ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream();
channel.setOutputStream(tmpOutput);
channel.setInputStream(System.in);
PrintStream shellStream = new PrintStream(channel.getOutputStream());
String currentWorkDirectory = null; 

// ... omit your code 

for (String command : commands) {

    shellStream.println(command);
    shellStream.flush();

    Thread.sleep(15);  // sleep 15ms, wait for output. maybe not very rigorous
    // read output 
    String commandOutput = tmpOutput.toString();

    // clear and reset stream
    tmpOutput.reset();

    if (command == "pwd") {
        //if output not equal to "home/rooot/Downloads"
        currentWorkDirectory = commandOutput;

        if(currentWorkDirectory != "home/rooot/Downloads"){
            break;
        }
    }

}