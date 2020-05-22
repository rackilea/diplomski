public static void main(String[] args) {
        // TODO Auto-generated method stub
        String Name;
        int age = 0;
        double height = 0;

        Scanner inReader = new Scanner(System.in);
        System.out.println("What is their name?");
        Name = inReader.nextLine();
        System.out.println("What is their age?");
        age = inReader.nextInt();
        System.out.println("What is their height?");
        height = inReader.nextDouble ();
        System.out.println (Name + " " + age + " " + "  " + height);
    }