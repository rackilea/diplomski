someObj.sum(1, 2, new Command<Integer>() {

 public void execute(Integer result) {
  System.out.println("Result is: " + result);
 }
});