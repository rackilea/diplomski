Semaphore sem = new Semaphore(5); //initialization in your data structure

//...

public void yourThreadFunction() {
    // [...] in your readers threads:
    // each thread will of course have to use the same semaphore
    // A thread must aquire a token from the semaphore before accessing your variable
    sem.aquire(); //this call hangs until a permit is available
    // read your value and do some computation
    // only 5 threads can be inside this part because of the aquire
    sem.release(); // release the token/permits
}