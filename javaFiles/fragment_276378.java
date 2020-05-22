@Override
public void run() {
    while(true) {
        try {
            whileListening();
        } catch(Exception e) {}
    }
}