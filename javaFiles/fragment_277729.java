Thread t = new Thread(new Runnable(){
    public void run(){
        // might need to try/catch round this
        while((line = bufferedReader.readLine()) != null){
                System.out.println(line);                                       
        }
    }
}).start();