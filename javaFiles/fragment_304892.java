ExecutorService executor = new FixedThreadPool(100); //pool of 100 threads

...

Runnable r = new Runnable() {

    public void run() {
        try {
            System.out.println(cmd);
            Process process = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }  
    }
}

executor.submit(r);