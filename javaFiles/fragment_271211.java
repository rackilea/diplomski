public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int n1;
    do {
        System.out.println("Enter a positive integer value: ");
        n1 = input.nextInt();
    } while (n1 <= 0);

    choose_function(n1);
    System.out.println();
    input.close();
}

public static void choose_function(int n) {
    if (n % 2 == 0) {
        compute_even(n);
    } else {
        compute_odd(n);
    }
}

public static void compute_even(int k) {
    int r = 0;
    while (r <= k) {
    System.out.print(""+r+" ");
        r = r + 2;  
    } 
}
public static void compute_odd(int k) {
    int r = 1;
    while (r <= k){
        System.out.print(""+r+" ");
        r = r+2;   
    }
}