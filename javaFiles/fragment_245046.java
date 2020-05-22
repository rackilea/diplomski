public static void main(String[] args)
{

    boolean myVariable = true;
    long startTime = 0;
    long endTime = 0;
    long duration1 = 0;
    long duration2 = 0;


    for(int i=0; i<1000; i++) {
        startTime = System.nanoTime();
        myVariable = !myVariable;
        endTime = System.nanoTime();

        duration1 += (endTime - startTime);


        startTime = System.nanoTime();
        myVariable ^= myVariable;
        endTime = System.nanoTime();

        duration2 += (endTime - startTime);

    }

        System.out.println("The duration for the first operation is :" + (duration1/1000));
        System.out.println("The duration for second operation is :" + (duration2/1000));
}