class Main {

  public static boolean isBalanced(String expr) {
    Stack<String> stack = new Stack<>();
    try{
      for (int i = 0; i<expr.length(); i++){
        if (expr.charAt(i) == ('(')){
          stack.push("(");
        } else if (expr.charAt(i) == (')')){
          stack.pop();
        }
      }
      if (stack.isEmpty()){
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(isBalanced("("));
    System.out.println(isBalanced("(()"));
    System.out.println(isBalanced("())"));
    System.out.println(isBalanced("((()))"));
    System.out.println(isBalanced("(()())"));
  }
}