public static <T> void executeMultiplication( LinkedStack<T> stack )
{
  T a = stack.pop();
  T b = stack.pop();
  T c = multiplication( a, b );
  stack.push( c );
}