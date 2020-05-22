Runnable myrunnable = new Runnable() {
    public void run() {
        YourFunction();//Call your function
    }
}

new Thread(myrunnable).start();//Call it when you need to run the function