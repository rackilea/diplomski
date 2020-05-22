int index = 200;

while(index != 0)
{
    index--;
    System.out.println("The value is: " + index);
    try {
        //200 * 5 milliseconds = 1 second
        Thread.sleep((long) 5);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}