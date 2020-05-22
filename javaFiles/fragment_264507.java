public static void main(String[] args) {
    System.out.println("Hello and welcome! Please enter the following: ");
    print(userName());
    print(userGender()); 
  }

  public static String userName() {
    try(Scanner sc = new Scanner(System.in)){ // this is try resource see which will close your resource once you are done in the try block see https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
      System.out.print("Enter name: ");
      return sc.next();
    }
  }

  public static String userGender() {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter Gender: ");
      return sc.next();
    }
  }

  public static void print(String a) {
    System.out.println(a);
  }