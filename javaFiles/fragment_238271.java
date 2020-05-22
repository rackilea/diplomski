public void autoClose(){
    System.out.print("Door closing in 5 seconds . . .");

    //right before it starts the timer and task
    timer(5);

    //then resume here after the timer completes
    activate();
}