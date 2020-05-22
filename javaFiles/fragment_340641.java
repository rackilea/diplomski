while (true) {
    while (inputStream.available() > 0) {
        int i = inputStream.read(buffer, 0, 1024);
        if (i < 0) {
            break;
        }
        System.out.print(new String(buffer, 0, i));//It is printing the response to console
    }
    System.out.println("done");

    channel.close();  // this closes the jsch channel

    if (channel.isClosed()) {
        System.out.println("exit-status: " + channel.getExitStatus());
        break;
    }
    try{Thread.sleep(1000);}catch(Exception ee){}
}