class Main
{
    public static void main(String[] args) {
        System.out.println("Enter the range for shipment numbers :");
        int n;
        boolean first = true;

        Scanner sc = new Scanner(System.in);
        int range1 = sc.nextInt();
        int range2 = sc.nextInt();

        for(int i = range1; i <= range2; i++){
            int num = i;
            boolean numberIsAwesome = true;

            while (num > 0)
            {
                n = num % 10;

                if(n % 3 != 0){
                    numberIsAwesome = false;
                }

                num = num / 10;
            }

            if (numberIsAwesome) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false;
            }
        }
        System.out.println();
    }
}