public static void main(String[] args)
{
    Scanner input = new Scanner(System.in);
    System.out.println("Start stopwatch [press s]: ");
    System.out.println("Stop  stopwatch [press q]: ");

    Timer timer = new Timer();
    input.next();
    timer.start();

    input.next();
    timer.stop();

    System.out.println("Elapsed time: "+ timer.getElapsedTime()+" milliseconds");

    timer.reset();

    input.next();
    timer.start();

    input.next();
    timer.stop();

    System.out.println("Elapsed time: "+ timer.getElapsedTime()+" milliseconds");
}