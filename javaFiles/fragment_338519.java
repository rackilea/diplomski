public static void main(String[] args) {   
        Scanner input = new Scanner(System.in);
        System.out.print("Enter weight: ");
        double weight = input.nextInt();
        System.out.print("Enter height: ");
        double height = input.nextInt();
        double bmi = weight / (height * height) * 703;
        System.out.println(bmi);
    }