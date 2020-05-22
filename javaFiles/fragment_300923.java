Thread sendWeeklyEmailThread = new Thread(new Runnable(){
    public void run()
    {
        readWeeklyEmails();
        generateGraphs();
        sendMailWithAttachment();
        clean(); //cleanup....
    }
});
sendWeeklyEmailThread.start();