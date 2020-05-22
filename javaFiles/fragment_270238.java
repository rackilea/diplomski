class TaskCompletedHandler{ // inner class
    private static final int NUMBER_OF_RESPONSES = 4;//just example

    private int tasksCompleted;

    public void notifyOfCompletedTask(){
        tasksCompleted++;
        if (tasksCompleted == NUMBER_OF_RESPONSES){
            blockerWindow.hide(); 
        }
    }
}