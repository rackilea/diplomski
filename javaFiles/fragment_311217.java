class MyClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> addToStack = new Stack<Integer>();

        int num;
        do {
            System.out.print("Enter the a list of positive integers. Terminate with a 0.");
            num = sc.nextInt();
            addToStack.push(num);
        } while (num != 0);

        //sort reverse order 
        Collections.sort(addToStack, Collections.reverseOrder());

        System.out.print(addToStack);
    }
}