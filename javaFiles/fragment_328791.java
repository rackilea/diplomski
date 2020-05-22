else if(currentPatronTimeLeft == 0 && lineSize != 0)
{
    myQueue.poll();
    lineSize--;
    // insert following lines:
    if (lineSize > 0) {
        currentPatronTimeLeft =myQueue.peek() + 1; // +1 <--> following decrement
    }
    // end of my insert
    System.out.println("A customer has been removed from the queue");
    totalCheckedOut++;
    System.out.println("The Queue size is now: "+ lineSize);
}