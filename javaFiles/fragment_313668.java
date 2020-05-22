public void run() {
    int i = 0;
    while(i<=200){
        if (i == 200){
            startNewRound();
            break;
        }
        else{
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                if (isLateToTimeout){
                    startNewRound();
                    break;
                }
                else{
                    i = 0;
                }
            }
        }
        i++;
    }
}