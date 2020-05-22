import java.util.Scanner;

class SequencePrinter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("number of threads: ");
        final int numberOfThreads = scanner.nextInt();

        System.out.print("maximum number to print: ");
        final int maximumNumber = scanner.nextInt();

        scanner.close();

        for (int index = 0; index < numberOfThreads; ++index)
        {
            final int workerIndex = index;

            Thread worker = new Thread(new Runnable()
            {
                public void run()
                {
                    for (int number = workerIndex; number <= maximumNumber; number += numberOfThreads)
                    {
                        print(workerIndex, number);
                    }
                }
            });

            worker.start();
        }
    }

    synchronized
    private static void print(int thread, int number)
    {
        System.out.println("thread " + thread + ", number " + number);
    }
}