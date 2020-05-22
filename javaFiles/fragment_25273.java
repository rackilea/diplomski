public static void main(String[] args) {
    System.out.println(getNumbers(100, 120));
    System.out.println(getNumbers(1000, 1000));
    System.out.println(getNumbers(123, 456));

    //Invalid input test case
    System.out.println(getNumbers(20, 10));


    try {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please Enter The Number of test cases: ");
        int t=Integer.parseInt(br.readLine());
        System.out.println("Please Enter A: ");
        int a=Integer.parseInt(br.readLine());
        System.out.println("Please Enter B: ");
        int b=Integer.parseInt(br.readLine());
        System.out.println(getNumbers(a, b));

    } catch (NumberFormatException e) {
        //TODO: Treat this!!!!
        e.printStackTrace();
    } catch (IOException e) {
        //TODO: Treat this!!!!
        e.printStackTrace();
    }

}