public class FindSecondMax {

public static void main(String args[]) {

int max = Integer.parseInt(args[0]);
int min = Integer.MAX_VALUE;
int i = 1;
while (i < args.length) {

    int nums = Integer.parseInt(args[i]);

    if (nums > max)
        max = nums;
    if (nums < min)
        min = nums;
    i++;
}

if (min == max) {
    System.out.println("There is no secondmax");
} else {
    int max1 = max;
    max = Integer.parseInt(args[0]);
    int j = 1;
    while (j < args.length) {
        int nums = Integer.parseInt(args[j]);

        if (nums > max && nums < max1)
            max = nums;
        j++;
    }
    int max2 = max;
    System.out.println(max2);
}
}
}