@DataPoints
public static int[] ints = ints();

public static int[] ints()
{
    System.out.println("Generator called");
    return new int[]{1, 2, 3, 4, 5};
}