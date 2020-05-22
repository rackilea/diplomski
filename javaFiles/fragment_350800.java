public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     System.out.println("enter string ");
     String value = scanner.nextLine(); 
     StringBuilder builder = new StringBuilder(value); // mutable string
     System.out.println("reversed value: " + builder.reverse()); // output result
  }