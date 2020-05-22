public static void main(String[] args) {
  MyFinder myFinder = new MyFinder();
  if (args.length > 0) {
    switch (args[0]) {
      case "myFind":
        myFinder.myFind();
        break;
      case "methodB":
        myFinder.methodB();
        break;
      default:
        System.err.println("Unkown target");
        break;
    }
  }
}