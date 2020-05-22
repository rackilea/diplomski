// open a channel
    channel = session.openChannel("exec");
    // type in your command
    String command = "./path/to/your_script.sh --add_params \n";
    //Below command will execute the data you set in the previous line
    ((ChannelExec) channel).setCommand(command);
    channel.connect();