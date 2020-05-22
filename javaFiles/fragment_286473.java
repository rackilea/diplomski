public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter the number of sides in polygon");
        int n = input.nextInt();

        System.out.println(" Enter the distance between two points");
        double s = input.nextDouble();
        double area = (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI / n));

        //Print result
        System.out.println (" Area is " + area);
        System.out.println (" Perimeter is " + s*n);

    }