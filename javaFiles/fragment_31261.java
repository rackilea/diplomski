public static void main (String [] args) {
    MainRoutine routine = new MainRoutine();

    while(true) {
        if(boIsRunning) {
            routine.continueRunning();
        } else {
            routine.startRunning();
        }    
    }
}