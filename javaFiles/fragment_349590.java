public class RandomInt {
 public static void main(String[] args) {
    int size = 10;
    int max = 10;
    int[] array = new int[size];
    int[] count = new int[max]; //count[0,0,0,0,0,0,0,0,0,0]
    int loop = 0;

    Random generator = new Random();


    for (int i = 0; i < size; i++) 
    {
        array[i] = generator.nextInt(max); // Generates 100 random numbers between 0 and 9 and stores them in array[]
        System.out.print(array[i]+" ");
    }

    for (int x = 0; x < size; x++) 
    {// loop through 10 elements in count
            for(int j = 0; j < 10; j++)
            { //loop through 100 elements in array
                if (array[x] == j) 
                {// loop through each 100 elements of array[x] and if element array[x] = value
                    count[j] += 1; // then count[x] = x + 1
                    //System.out.print(count[j]);
                }
            }

    }

    System.out.println("3 appears " + count[3] + " times.");
}