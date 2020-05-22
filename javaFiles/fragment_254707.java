public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  String input = sc.nextLine();
  try{
    int number = Integer.parseInt(input);

    if(number < 0) {
        System.out.println("Number is smaller than 0.");
    } else if(number > 0) {
        System.out.println("Number is greater than 0.");
    } else {
      System.out.println("Number is 0.");
    }
  } catch(IllegalArgumentException e) {
    System.out.println("Please insert a valid number.");
  } finally {
    sc.close();
  }
}