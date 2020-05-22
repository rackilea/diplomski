for(int i = 0; i < 10; i++) { 
    thread = new Thread(this); 
    thread.start(); 

    thread.join();    // Wait for it to finish.
}